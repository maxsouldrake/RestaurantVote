package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.service.MealService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:16
 **/

@RestController
@RequestMapping(value = "/admin/restaurants/{restaurantId}/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealRestController {
    private final MealService mealService;

    public AdminMealRestController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal create(@RequestBody Meal meal, @PathVariable int restaurantId) {
        return mealService.create(meal, restaurantId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal update(@RequestBody Meal meal, @PathVariable int restaurantId, @PathVariable int id) {
        meal.setId(id);
        return mealService.update(meal, restaurantId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int restaurantId, @PathVariable int id) {
        mealService.delete(id, restaurantId);
    }
}
