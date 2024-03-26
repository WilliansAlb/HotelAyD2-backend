package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
