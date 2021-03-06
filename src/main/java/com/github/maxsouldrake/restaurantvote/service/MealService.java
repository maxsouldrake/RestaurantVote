package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.repository.MealRepository;
import com.github.maxsouldrake.restaurantvote.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;

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
        return mealRepository.findAllByRestaurantIdAndDate(restaurantId, LocalDate.now());
    }

    public Meal get(int id, int restaurantId) {
        return checkNotFound(mealRepository.findByIdAndRestaurantIdAndDate(id, restaurantId, LocalDate.now()), id, restaurantId);
    }

    @Transactional
    public Meal create(Meal meal, int restaurantId) {
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        return mealRepository.save(meal);
    }

    @Transactional
    public Meal update(Meal meal, int restaurantId) {
        int id = Objects.requireNonNull(meal.getId());
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        checkNotFound(get(id, restaurantId), id, restaurantId);
        return mealRepository.save(meal);
    }

    @Transactional
    public void delete(int id, int restaurantId) {
        checkNotFound(mealRepository.deleteByIdAndRestaurantIdAndDate(id, restaurantId, LocalDate.now()) != 0, id, restaurantId);
    }
}
