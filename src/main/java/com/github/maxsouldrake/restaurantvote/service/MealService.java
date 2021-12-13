package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.repository.MealRepository;
import com.github.maxsouldrake.restaurantvote.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-12-07 13:55
 **/

@Service
@Transactional(readOnly = true)
public class MealService {
    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    public MealService(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Meal> getAll(int restaurantId) {
        return mealRepository.findAllByRestaurantId(restaurantId);
    }

    public Meal get(int id, int restaurantId) {
        return mealRepository.findByIdAndRestaurantId(id, restaurantId);
    }

    @Transactional
    public Meal update(Meal meal, int restaurantId) {
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        return mealRepository.save(meal);
    }

    @Transactional
    public Meal create(Meal meal, int restaurantId) {
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        return mealRepository.save(meal);
    }

    @Transactional
    public void delete(int id, int restaurantId) {
        mealRepository.deleteByIdAndRestaurantId(id, restaurantId);
    }
}
