package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import com.github.maxsouldrake.restaurantvote.repository.RestaurantRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;

/**
 * @author SoulDrake
 * @create 2021-12-07 14:48
 **/

@Service
@Transactional(readOnly = true)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll(Sort.by("title"));
    }

    public Restaurant get(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        checkNotFound(restaurant.isPresent(), id);
        return restaurant.get();
    }

    public Restaurant getByTitle(String title) {
        return checkNotFound(restaurantRepository.findByTitle(title), title);
    }

    public Restaurant getWithMenuAndVotes(int id) {
        return checkNotFound(restaurantRepository.findWithMenuAndVotes(id, LocalDate.now()), id);
    }

    @Transactional
    public Restaurant update(Restaurant restaurant) {
        return checkNotFound(restaurantRepository.save(restaurant), restaurant.getId());
    }

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(int id) {
        checkNotFound(restaurantRepository.existsById(id), id);
        restaurantRepository.deleteById(id);
    }
}
