package com.bank.online.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.online.fund.transfer.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
