package com.qsp.flight_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.flight_management_system.dto.Food;

public interface FoodRepo extends JpaRepository<Food, Integer>{

}
