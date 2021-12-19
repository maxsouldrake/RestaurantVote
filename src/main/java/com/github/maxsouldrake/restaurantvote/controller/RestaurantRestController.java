package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import com.github.maxsouldrake.restaurantvote.service.MealService;
import com.github.maxsouldrake.restaurantvote.service.RestaurantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:29
 **/

@RestController
@RequestMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController {
    private final RestaurantService restaurantService;
    private final MealService mealService;

    public RestaurantRestController(RestaurantService restaurantService, MealService mealService) {
        this.restaurantService = restaurantService;
        this.mealService = mealService;
    }


    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return restaurantService.get(id);
    }

    @GetMapping("/by-title")
    public Restaurant getByTitle(@RequestParam String title) {
        return restaurantService.getByTitle(title);
    }

    @GetMapping("/{id}/menu")
    public List<Meal> getMenu(@PathVariable int id) {
        return mealService.getAll(id);
    }

    @GetMapping("/{id}/menu/{mealId}")
    public Meal getMeal(@PathVariable int mealId, @PathVariable int id) {
        return mealService.get(mealId, id);
    }
}
