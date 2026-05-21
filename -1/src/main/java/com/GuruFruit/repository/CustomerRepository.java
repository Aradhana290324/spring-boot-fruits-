package com.GuruFruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GuruFruit.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobile(
            String mobile
    );
}