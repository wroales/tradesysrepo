package com.billr.tradesysv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billr.tradesysv1.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
