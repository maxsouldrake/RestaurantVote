package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static com.github.maxsouldrake.restaurantvote.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealServiceTest extends AbstractServiceTest{
    @Autowired
    private MealService mealService;

    @Test
    void getAll() {
        assertThat(mealService.getAll(RESTAURANT_ID)).isEqualTo(List.of(restaurant1Meal1, restaurant1Meal2));
    }

    @Test
    void get() {
        assertEquals(mealService.get(MEAL_ID, RESTAURANT_ID), restaurant1Meal1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> mealService.get(NOT_FOUND_ID, RESTAURANT_ID));
    }

    @Test
    void getNotOwn() {
        assertThrows(NotFoundException.class, () -> mealService.get(MEAL_ID, RESTAURANT_ID + 1));
    }

    @Test
    void create() {
        Meal newMeal = getNew(Meal.class);
        Meal created = mealService.create(getNew(Meal.class), RESTAURANT_ID);
        Integer newId = created.getId();
        newMeal.setId(newId);
        assertEquals(created, newMeal);
        assertEquals(mealService.get(newId, RESTAURANT_ID), newMeal);
    }

    @Test
    void duplicateTitleDateCreate() {
        assertThrows(DataAccessException.class, () ->
                mealService.create(new Meal(null, MEAL_TITLE, 100), RESTAURANT_ID));
    }

    @Test
    void update() {
        Meal updated = mealService.update(getUpdated(Meal.class), RESTAURANT_ID);
        assertEquals(mealService.get(MEAL_ID, RESTAURANT_ID), updated);
    }

    @Test
    void updateNotOwn() {
        assertThrows(NotFoundException.class, () -> mealService.update(getUpdated(Meal.class), RESTAURANT_ID + 1));
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> mealService.delete(MEAL_ID, RESTAURANT_ID));
        assertThrows(NotFoundException.class, () -> mealService.get(MEAL_ID, RESTAURANT_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> mealService.delete(NOT_FOUND_ID, RESTAURANT_ID));
    }

    @Test
    void deleteNotOwn() {
        assertThrows(NotFoundException.class, () -> mealService.delete(MEAL_ID, RESTAURANT_ID + 1));
    }
}