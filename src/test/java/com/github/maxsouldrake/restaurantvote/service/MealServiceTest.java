package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.model.Meal;
import com.github.maxsouldrake.restaurantvote.testdata.RestaurantTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

import static com.github.maxsouldrake.restaurantvote.testdata.MealTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class MealServiceTest {
    @Autowired
    private MealService mealService;

    @Test
    void getAll() {
        assertThat(mealService.getAll(RestaurantTestData.RESTAURANT_ID)).isEqualTo(List.of(restaurant1Meal1, restaurant1Meal2, restaurant1Meal3, restaurant1Meal4));
    }

    @Test
    void get() {
        assertEquals(mealService.get(MEAL_ID, RestaurantTestData.RESTAURANT_ID), restaurant1Meal1);
    }

    @Test
    void getNotFound() {
    }

    @Test
    void getNotOwn() {
    }

    @Test
    void create() {
        Meal newMeal = getNew();
        Meal created = mealService.create(getNew(), RestaurantTestData.RESTAURANT_ID);
        Integer newId = created.getId();
        newMeal.setId(newId);
        assertEquals(created, newMeal);
        assertEquals(mealService.get(newId, RestaurantTestData.RESTAURANT_ID), newMeal);
    }

    @Test
    void duplicateTitleDateCreate() {
        assertThrows(DataAccessException.class, () ->
                mealService.create(new Meal(null, MEAL_TITLE, 100,
                        LocalDate.of(2020,1,30)), RestaurantTestData.RESTAURANT_ID));
    }

    @Test
    void update() {
        Meal updated = mealService.update(getUpdated(), RestaurantTestData.RESTAURANT_ID);
        assertEquals(mealService.get(MEAL_ID, RestaurantTestData.RESTAURANT_ID), updated);
    }

    @Test
    void updateNotOwn() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteNotFound() {
    }

    @Test
    void deleteNotOwn() {
    }
}