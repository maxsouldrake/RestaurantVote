package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import com.github.maxsouldrake.restaurantvote.service.RestaurantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:29
 **/

@RestController
@RequestMapping(value = "/admin/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantRestController {
    private final RestaurantService restaurantService;

    public AdminRestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant create(@RequestBody @Valid Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant update(@RequestBody @Valid Restaurant restaurant, @PathVariable int id) {
        restaurant.setId(id);
        return restaurantService.update(restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        restaurantService.delete(id);
    }
}
