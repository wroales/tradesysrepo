package com.billr.tradesysv1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billr.tradesysv1.models.Russell3000;

@Repository
public interface Russell3000Repository extends JpaRepository<Russell3000, Long> {
	

	
}