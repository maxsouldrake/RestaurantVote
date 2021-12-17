package com.github.maxsouldrake.restaurantvote;

import com.github.maxsouldrake.restaurantvote.model.*;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;

/**
 * @author SoulDrake
 * @create 2021-12-14 20:29
 **/

public class TestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 2;
    public static final int RESTAURANT_ID = START_SEQ + 3;
    public static final int MEAL_ID = START_SEQ + 5;
    public static final int VOTE_ID = START_SEQ + 16;
    public static final int NOT_FOUND_ID = 99999;

    public static final String USER_EMAIL = "user1@gmail.com";
    public static final String RESTAURANT_TITLE = "Burger Frog";
    public static final String MEAL_TITLE = "burger";

    public static final User user1 = new User(USER_ID, USER_EMAIL, "user1pass", Role.USER);
    public static final User user2 = new User(USER_ID + 1, "user2@gmail.com", "user2pass", Role.USER);
    public static final User admin = new User(ADMIN_ID, "admin@gmail.com", "adminpass", Role.ADMIN);

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_ID, RESTAURANT_TITLE);
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT_ID + 1, "Pizza Shot");

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

    public static final Vote user1vote1 = new Vote(VOTE_ID, user1, restaurant1, LocalDate.of(2020, 1, 30));
    public static final Vote user1vote2 = new Vote(VOTE_ID + 1, user1, restaurant2, LocalDate.of(2020, 1, 31));
    public static final Vote user2vote1 = new Vote(VOTE_ID + 2, user2, restaurant1, LocalDate.of(2020, 1, 30));
    public static final Vote user2vote2 = new Vote(VOTE_ID + 3, user2, restaurant2, LocalDate.of(2020, 1, 31));

    public static <T extends AbstractBaseEntity> T getNew(Class<T> clazz) {
        T newObj = null;
        if (clazz == User.class) {
            newObj = clazz.cast(new User(null, "newUser@gmail.com", "newpass", Role.USER));
        }
        if (clazz == Restaurant.class) {
            newObj = clazz.cast(new Restaurant(null, "New Restaurant"));
        }
        if (clazz == Meal.class) {
            newObj = clazz.cast(new Meal(null, "newMeal", 111, LocalDate.of(2020, 1, 31)));
        }
        if (clazz == Vote.class) {
            newObj = clazz.cast(new Vote(null, user1, restaurant1, LocalDate.now()));
        }
        return newObj;
    }

    public static <T extends AbstractBaseEntity> T getUpdated(Class<T> clazz) {
        T updatedObj = null;
        if (clazz == User.class) {
            User user = new User(USER_ID, user1.getEmail(), user1.getPassword(), user1.getRole());
            user.setEmail("upd@gmail.com");
            user.setPassword("updpass");
            updatedObj = clazz.cast(user);
        }
        if (clazz == Restaurant.class) {
            Restaurant restaurant = new Restaurant(RESTAURANT_ID, restaurant1.getTitle());
            restaurant.setTitle("Updated Restaurant");
            updatedObj = clazz.cast(restaurant);
        }
        if (clazz == Meal.class) {
            Meal meal = new Meal(MEAL_ID, restaurant1Meal1.getTitle(), restaurant1Meal1.getPrice(), restaurant1Meal1.getDate());
            meal.setTitle("updMeal");
            meal.setPrice(222);
            updatedObj = clazz.cast(meal);
        }
        if (clazz == Vote.class) {
            Vote vote = new Vote(VOTE_ID, user1vote1.getUser(), user1vote1.getRestaurant(), user1vote1.getDate());
            vote.setRestaurant(restaurant2);
            updatedObj = clazz.cast(vote);
        }
        return updatedObj;
    }
}
