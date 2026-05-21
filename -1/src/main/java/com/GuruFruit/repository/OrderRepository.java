package com.GuruFruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GuruFruit.entity.OrderData;

public interface OrderRepository
        extends JpaRepository<OrderData, Long> {
	List<OrderData> findByMobileOrderByIdDesc(
	        String mobile
	);
}