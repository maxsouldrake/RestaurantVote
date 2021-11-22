package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SoulDrake
 * @create 2021-11-22 20:59
 **/

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
