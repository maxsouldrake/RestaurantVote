package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static com.github.maxsouldrake.restaurantvote.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest extends AbstractServiceTest{
    @Autowired
    private RestaurantService restaurantService;

    @Test
    void getAll() {
        assertThat(restaurantService.getAll()).isEqualTo(List.of(restaurant1, restaurant2));
    }

    @Test
    void get() {
        assertEquals(restaurantService.get(RESTAURANT_ID), restaurant1);
    }

    @Test
    void getByTitle() {
        assertEquals(restaurantService.getByTitle(RESTAURANT_TITLE), restaurant1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> restaurantService.get(NOT_FOUND_ID));
    }

    @Test
    void create() {
        Restaurant newRestaurant = getNew(Restaurant.class);
        Restaurant created = restaurantService.create(getNew(Restaurant.class));
        Integer newId = created.getId();
        newRestaurant.setId(newId);
        assertEquals(created, newRestaurant);
        assertEquals(restaurantService.get(newId), newRestaurant);
    }

    @Test
    void duplicateTitleCreate() {
        assertThrows(DataAccessException.class, () ->
                restaurantService.create(new Restaurant(null, RESTAURANT_TITLE)));
    }

    @Test
    void update() {
        Restaurant updated = restaurantService.update(getUpdated(Restaurant.class));
        assertEquals(restaurantService.get(RESTAURANT_ID), updated);
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> restaurantService.delete(RESTAURANT_ID));
        assertThrows(NotFoundException.class, () -> restaurantService.get(RESTAURANT_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> restaurantService.delete(NOT_FOUND_ID));
    }
}