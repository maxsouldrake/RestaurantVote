package com.github.maxsouldrake.restaurantvote.testdata;

import com.github.maxsouldrake.restaurantvote.model.Role;
import com.github.maxsouldrake.restaurantvote.model.User;

import static com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity.START_SEQ;

/**
 * Data class for testing
 *
 * @author SoulDrake
 * @create 2021-11-01 10:13
 **/

public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 2;
    public static final int NOT_FOUND_ID = 99999;
    public static final String USER_EMAIL = "user1@gmail.com";

    public static final User user1 = new User(USER_ID, USER_EMAIL, "user1pass", Role.USER);
    public static final User user2 = new User(USER_ID + 1, "user2@gmail.com", "user2pass", Role.USER);
    public static final User admin = new User(ADMIN_ID, "admin@gmail.com", "adminpass", Role.ADMIN);

    public static User getNew() {
        return new User(null, "newUser@gmail.com", "newpass", Role.USER);
    }

    public static User getUpdated() {
        User updated = new User(USER_ID, user1.getEmail(), user1.getPassword(), user1.getRole());
        updated.setEmail("upd@gmail.com");
        updated.setPassword("updpass");
        updated.setRole(Role.USER);
        return updated;
    }
}
