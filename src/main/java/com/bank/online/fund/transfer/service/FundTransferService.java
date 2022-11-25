package com.bank.online.fund.transfer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.fund.transfer.entity.Account;
import com.bank.online.fund.transfer.entity.Transaction;
import com.bank.online.fund.transfer.exception.AccountNotFoundException;
import com.bank.online.fund.transfer.exception.InsufficentFundsException;
import com.bank.online.fund.transfer.repository.AccountRepository;
import com.bank.online.fund.transfer.repository.TransactionRepository;
import com.bank.online.fund.transfer.vo.FundTransferVO;

@Service
public class FundTransferService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public Transaction transferFund(FundTransferVO fundTransfer){
		Transaction transaction = new Transaction();
		Account account = new Account();
		Optional<Account> accountOp = accountRepository.findById(fundTransfer.getAccountNo());
		if(accountOp.isPresent()) {
			account = accountOp.get();
		}else {
			throw new AccountNotFoundException();
		}
		
		if(account.getBalance()<fundTransfer.getAmount()) {
			throw new InsufficentFundsException();
		}else {
			account.setBalance(account.getBalance()-fundTransfer.getAmount());
			accountRepository.save(account);
			
			transaction.setAccountNo(fundTransfer.getAccountNo());
			transaction.setPayeeAccountNo(fundTransfer.getPayeeAccountNo());
			transaction.setAmount(fundTransfer.getAmount());
			transaction.setTransactioDate(new Date());
			transaction.setTransactionStatus("Success");
			transaction = transactionRepository.save(transaction);
		}
	
		return transaction;
	}

	public Account getAccountDetails(Long accountNo) {
		Optional<Account> accountOp = accountRepository.findById(accountNo);
		Account account = null;
		if(accountOp.isPresent()) {
			account = accountOp.get();
		}else {
			throw new AccountNotFoundException();
		}
		return account;
	}

	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}

	
}
