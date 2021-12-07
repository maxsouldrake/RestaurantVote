package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import com.github.maxsouldrake.restaurantvote.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-12-07 14:48
 **/

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant get(int id) {
        return restaurantRepository.findById(id).get();
    }

    public Restaurant update(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void delete(int id) {
        restaurantRepository.deleteById(id);
    }
}
