package com.billr.tradesysv1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billr.tradesysv1.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
	
	 List<Position> findByOrderBySymbolAsc();
	
}