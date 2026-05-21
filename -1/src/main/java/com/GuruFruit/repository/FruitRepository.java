package com.GuruFruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GuruFruit.*;
import com.GuruFruit.entity.Fruits;

public interface FruitRepository extends JpaRepository<Fruits, Long> {

}