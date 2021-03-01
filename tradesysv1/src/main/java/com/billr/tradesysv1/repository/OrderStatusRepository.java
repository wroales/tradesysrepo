package com.billr.tradesysv1.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billr.tradesysv1.models.OrderStatus;



@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
	
//	String q1="SELECT t.side,t.symbol,t.qty,t.limit_price,t.type,t.created_at,t.id ";
//	String q2="FROM orderstatus t WHERE t.id = :id ";
//    @Query(q1+q2) 
//    public Optional<OrderStatus> findById(@Param("id") String id);
	Optional<OrderStatus> findById(String id);


}