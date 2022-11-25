package com.bank.online.fund.transfer.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.online.fund.transfer.exception.AccountNotFoundException;
import com.bank.online.fund.transfer.exception.InsufficentFundsException;

@ControllerAdvice
public class FundTransferExceptionController {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundException(AccountNotFoundException accountNotFoundException){
		return new ResponseEntity<>("Account Not Found, Please provide correct Account",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficentFundsException.class)
	public ResponseEntity<Object> inSufficentFundsException(InsufficentFundsException intSuFundsException){
		return new ResponseEntity<>("Insufficent Funds, Please check your account balance",HttpStatus.BAD_REQUEST);
	}

}
