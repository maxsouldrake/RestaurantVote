package com.github.maxsouldrake.restaurantvote.testdata;

import com.github.maxsouldrake.restaurantvote.model.Vote;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;
import static com.github.maxsouldrake.restaurantvote.testdata.RestaurantTestData.restaurant1;
import static com.github.maxsouldrake.restaurantvote.testdata.RestaurantTestData.restaurant2;
import static com.github.maxsouldrake.restaurantvote.testdata.UserTestData.user1;
import static com.github.maxsouldrake.restaurantvote.testdata.UserTestData.user2;

/**
 * @author SoulDrake
 * @create 2021-12-12 18:29
 **/

public class VoteTestData {
    public static final int VOTE_ID = START_SEQ + 16;

    public static final Vote user1vote1 = new Vote(VOTE_ID, user1, restaurant1, LocalDate.of(2020, 1, 30));
    public static final Vote user1vote2 = new Vote(VOTE_ID + 1, user1, restaurant2, LocalDate.of(2020, 1, 31));
    public static final Vote user2vote1 = new Vote(VOTE_ID + 2, user2, restaurant1, LocalDate.of(2020, 1, 30));
    public static final Vote user2vote2 = new Vote(VOTE_ID + 3, user2, restaurant2, LocalDate.of(2020, 1, 31));

    public static Vote getNew() {
        return new Vote(null, user1, restaurant1, LocalDate.now());
    }

    public static Vote getUpdated() {
        Vote updated = new Vote(VOTE_ID, user1vote1.getUser(), user1vote1.getRestaurant(), user1vote1.getDate());
        updated.setRestaurant(restaurant2);
        return updated;
    }
}
