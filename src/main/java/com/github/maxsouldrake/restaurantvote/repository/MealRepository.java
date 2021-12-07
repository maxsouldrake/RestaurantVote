package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-11-22 20:59
 **/

public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findAllByRestaurantId(int restaurantId);
    Meal findByIdAndRestaurantId(int id, int restaurantId);
    void deleteByIdAndRestaurantId(int id, int restaurantId);
}
