package com.bank.online.fund.transfer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="TRANSACTIONID")
	private Long tranactioId;
	
	@Column(name ="TRANSACTIONDATE")
	private Date transactioDate;
	
	@Column(name ="WITHINBANK")
	private boolean withInBank;
	
	@Column(name ="ACCOUNTNO")
	private Long accountNo;
	
	@Column(name ="PAYEEACCOUNTNO")
	private Long payeeAccountNo;
	
	@Column(name ="AMOUNT")
	private Double amount;
	
	@Column(name ="TRANSACTIONSTATUS")
	private String transactionStatus;
	
}
