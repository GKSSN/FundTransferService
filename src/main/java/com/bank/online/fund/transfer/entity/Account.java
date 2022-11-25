package com.bank.online.fund.transfer.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	
	@Column(name="ACCOUNTNO")
	private Long accountNo;
	
	@Column(name="ACCOUNTHOLDERNAME")
	private String accountHolderName;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="ACCOUNTTYPE")
	private String accountType;
	
	@Column(name="BALANCE")
	private Double balance;
	
	@Column(name="BANKNAME")
	private String bankName;
	
	@Column(name="BRANCHNAME")
	private String branchName;
	
	@Column(name="IFSCCODE")
	private String ifscCode;
	
}
