package com.github.maxsouldrake.restaurantvote.testdata;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;

/**
 * @author SoulDrake
 * @create 2021-12-12 18:29
 **/

public class RestaurantTestData {
    public static final int RESTAURANT_ID = START_SEQ + 3;
    public static final String RESTAURANT_TITLE = "Burger Frog";

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_ID, RESTAURANT_TITLE);
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT_ID + 1, "Pizza Shot");

    public static Restaurant getNew() {
        return new Restaurant(null, "New Restaurant");
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(RESTAURANT_ID, restaurant1.getTitle());
        updated.setTitle("Updated Restaurant");
        return updated;
    }
}
