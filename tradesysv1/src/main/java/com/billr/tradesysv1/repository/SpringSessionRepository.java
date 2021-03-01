package com.billr.tradesysv1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billr.tradesysv1.models.SpringSession;


@Repository
public interface SpringSessionRepository extends JpaRepository<SpringSession, String> {
	

	
}