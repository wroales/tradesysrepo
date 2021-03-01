package com.billr.tradesysv1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billr.tradesysv1.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}