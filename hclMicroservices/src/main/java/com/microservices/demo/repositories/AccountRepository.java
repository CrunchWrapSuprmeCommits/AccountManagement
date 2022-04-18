package com.microservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.beans.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
