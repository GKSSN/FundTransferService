package com.bank.online.fund.transfer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferVO {
	private Long accountNo;
	private Long payeeAccountNo;
	private Double amount;
	private String transactionType;
}
