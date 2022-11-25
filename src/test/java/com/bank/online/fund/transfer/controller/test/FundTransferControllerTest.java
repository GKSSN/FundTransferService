package com.bank.online.fund.transfer.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import com.bank.online.fund.transfer.repository.AccountRepository;
import com.bank.online.fund.transfer.repository.TransactionRepository;

@SpringBootTest
@AutoConfigureMockMvc
/*
 * @SqlGroup({
 * 
 * @Sql(value = "classpath:data.sql", executionPhase = BEFORE_TEST_METHOD) })
 */
public class FundTransferControllerTest {
	
	
	@Autowired
    private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    void fundTransferSuccessTest() throws Exception {
        final File jsonFile = new ClassPathResource("transaction_success.json").getFile();
        final String tranaction = Files.readString(jsonFile.toPath());

        this.mockMvc.perform(post("/online/transferFund")
                        .contentType(APPLICATION_JSON)
                        .content(tranaction))
                .andDo(print())
                .andExpect(jsonPath("$.transactionStatus").value("Success"));
    }
    
    @Test
    void fundTransferSuccessAccountNoInvalid() throws Exception {
        final File jsonFile = new ClassPathResource("transaction_accountno_invalid.json").getFile();
        final String tranaction = Files.readString(jsonFile.toPath());

        this.mockMvc.perform(post("/online/transferFund")
                        .contentType(APPLICATION_JSON)
                        .content(tranaction))
                .andDo(print())
                .andExpect(content().string("Account Not Found, Please provide correct Account"));
    }
    
    @Test
    void fundTransferSuccessInsifficientFund() throws Exception {
        final File jsonFile = new ClassPathResource("transaction_insufficient_fund.json").getFile();
        final String tranaction = Files.readString(jsonFile.toPath());

        this.mockMvc.perform(post("/online/transferFund")
                        .contentType(APPLICATION_JSON)
                        .content(tranaction))
                .andDo(print())
                .andExpect(content().string("Insufficent Funds, Please check your account balance"));
    }
    
    @Test
    void getAccountDetailsTest() throws Exception {

        this.mockMvc.perform(get("/online/getAccountDetails/10001")
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.accountNo").value("10001"))
                .andExpect(jsonPath("$.accountHolderName").value("Abhisheik"))
                .andExpect(jsonPath("$.dob").value("1990-12-30"))
                .andExpect(jsonPath("$.accountType").value("Savings"))
                .andExpect(jsonPath("$.balance").value(100000))
                .andExpect(jsonPath("$.bankName").value("HDFC"))
                .andExpect(jsonPath("$.branchName").value("HYD"))
                .andExpect(jsonPath("$.ifscCode").value("HDFC0001"));
        
    }
    
    @Test
    void getTranactionDetailsTest() throws Exception {
        this.mockMvc.perform(get("/online/getAllTransaction")
                        .contentType(APPLICATION_JSON))
                .andDo(print());
    }
}
