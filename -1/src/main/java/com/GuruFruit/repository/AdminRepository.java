package com.GuruFruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GuruFruit.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
}