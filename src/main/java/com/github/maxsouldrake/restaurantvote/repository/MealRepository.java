package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-11-22 20:59
 **/

public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findAllByRestaurantIdAndDate(int restaurantId, LocalDate date);

    Meal findByIdAndRestaurantIdAndDate(int id, int restaurantId, LocalDate date);

    int deleteByIdAndRestaurantIdAndDate(int id, int restaurantId, LocalDate date);
}
