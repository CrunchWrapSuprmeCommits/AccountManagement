package com.accountmanagement.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountmanagement.demo.beans.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
