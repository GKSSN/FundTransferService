package com.bank.online.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.online.fund.transfer.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
