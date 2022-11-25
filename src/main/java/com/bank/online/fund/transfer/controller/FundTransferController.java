package com.bank.online.fund.transfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.fund.transfer.entity.Account;
import com.bank.online.fund.transfer.entity.Transaction;
import com.bank.online.fund.transfer.service.FundTransferService;
import com.bank.online.fund.transfer.vo.FundTransferVO;

@RestController
@RequestMapping("/online")
public class FundTransferController {
	
	@Autowired
	FundTransferService fundTransferService;
	
	@PostMapping("/transferFund")
	public ResponseEntity<Transaction> transferFund(@RequestBody FundTransferVO fundTransfer){
		Transaction transaction  = fundTransferService.transferFund(fundTransfer);
		return ResponseEntity.ok(transaction);
	}
	
	@GetMapping("/getAccountDetails/{accountNo}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable Long accountNo){
		Account account  = fundTransferService.getAccountDetails(accountNo);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping("/getAllTransaction")
	public ResponseEntity<List<Transaction>> getTranactionDetails(){
		List<Transaction> transactionList  = fundTransferService.getAllTransaction();
		return ResponseEntity.ok(transactionList);
	}
}
