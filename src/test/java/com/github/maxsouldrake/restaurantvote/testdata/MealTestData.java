package com.github.maxsouldrake.restaurantvote.testdata;

import com.github.maxsouldrake.restaurantvote.model.Meal;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;

/**
 * @author SoulDrake
 * @create 2021-12-12 18:29
 **/

public class MealTestData {
    public static final int MEAL_ID = START_SEQ + 5;
    public static final String MEAL_TITLE = "burger";

    public static final Meal restaurant1Meal1 = new Meal(MEAL_ID, MEAL_TITLE, 1299, LocalDate.of(2020,1,30));
    public static final Meal restaurant1Meal2 = new Meal(MEAL_ID + 1, "salad", 599, LocalDate.of(2020,1,30));
    public static final Meal restaurant1Meal3 = new Meal(MEAL_ID + 5, "burger", 1399, LocalDate.of(2020,1,31));
    public static final Meal restaurant1Meal4 = new Meal(MEAL_ID + 6, "coffee", 299, LocalDate.of(2020,1,31));

    public static final Meal restaurant2Meal1 = new Meal(MEAL_ID + 2, "pizza", 1340, LocalDate.of(2020,1,30));
    public static final Meal restaurant2Meal2 = new Meal(MEAL_ID + 3, "chicken", 815, LocalDate.of(2020,1,30));
    public static final Meal restaurant2Meal3 = new Meal(MEAL_ID + 4, "tea", 215, LocalDate.of(2020,1,30));
    public static final Meal restaurant2Meal4 = new Meal(MEAL_ID + 7, "pizza", 1340, LocalDate.of(2020,1,31));
    public static final Meal restaurant2Meal5 = new Meal(MEAL_ID + 8, "fries", 1340, LocalDate.of(2020,1,31));
    public static final Meal restaurant2Meal6 = new Meal(MEAL_ID + 9, "egg salad", 1340, LocalDate.of(2020,1,31));
    public static final Meal restaurant2Meal7 = new Meal(MEAL_ID + 10, "juice", 1340, LocalDate.of(2020,1,31));

    public static Meal getNew() {
        return new Meal(null, "newMeal", 111, LocalDate.of(2020,1,31));
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(MEAL_ID, restaurant1Meal1.getTitle(), restaurant1Meal1.getPrice(), restaurant1Meal1.getDate());
        updated.setTitle("updMeal");
        updated.setPrice(222);
        return updated;
    }
}
