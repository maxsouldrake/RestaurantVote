package com.github.maxsouldrake.restaurantvote;

import com.github.maxsouldrake.restaurantvote.model.*;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;

/**
 * @author SoulDrake
 * @create 2021-12-14 20:29
 **/

public class TestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 2;
    public static final int RESTAURANT_ID = START_SEQ + 3;
    public static final int OLD_MEAL_ID = START_SEQ + 5;
    public static final int MEAL_ID = START_SEQ + 11;
    public static final int OLD_VOTE_ID = START_SEQ + 16;
    public static final int VOTE_ID = START_SEQ + 18;
    public static final int NOT_FOUND_ID = 99999;

    public static final String USER_EMAIL = "user1@gmail.com";
    public static final String RESTAURANT_TITLE = "Burger Frog";
    public static final String MEAL_TITLE = "burger";

    public static final User user1 = new User(USER_ID, USER_EMAIL, "user1pass", Role.USER);
    public static final User user2 = new User(USER_ID + 1, "user2@gmail.com", "user2pass", Role.USER);
    public static final User admin = new User(ADMIN_ID, "admin@gmail.com", "adminpass", Role.ADMIN);

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_ID, RESTAURANT_TITLE);
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT_ID + 1, "Pizza Shot");

    public static final Meal restaurant1Meal1 = new Meal(MEAL_ID, MEAL_TITLE, 1299);
    public static final Meal restaurant1Meal2 = new Meal(MEAL_ID + 1, "salad", 599);

    public static final Vote user1vote = new Vote(VOTE_ID, restaurant2);
    public static final Vote user1TodayVote = new Vote(VOTE_ID, restaurant1);

    public static <T extends AbstractBaseEntity> T getNew(Class<T> clazz) {
        T newObj = null;
        if (clazz == User.class) {
            newObj = clazz.cast(new User(null, "newUser@gmail.com", "newpass", Role.USER));
        }
        if (clazz == Restaurant.class) {
            newObj = clazz.cast(new Restaurant(null, "New Restaurant"));
        }
        if (clazz == Meal.class) {
            newObj = clazz.cast(new Meal(null, "newMeal", 111));
        }
        if (clazz == Vote.class) {
            newObj = clazz.cast(new Vote(null, restaurant2));
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
            Meal meal = new Meal(MEAL_ID, restaurant1Meal1.getTitle(), restaurant1Meal1.getPrice());
            meal.setTitle("updMeal");
            meal.setPrice(222);
            updatedObj = clazz.cast(meal);
        }
        if (clazz == Vote.class) {
            Vote vote = new Vote(VOTE_ID, restaurant1);
            vote.setUser(user1TodayVote.getUser());
            vote.setRestaurant(restaurant2);
            updatedObj = clazz.cast(vote);
        }
        return updatedObj;
    }
}
