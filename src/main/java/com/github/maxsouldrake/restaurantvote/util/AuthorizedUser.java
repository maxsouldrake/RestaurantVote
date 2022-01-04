package com.github.maxsouldrake.restaurantvote.util;

import com.github.maxsouldrake.restaurantvote.model.User;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * @author SoulDrake
 * @create 2022-01-03 19:34
 **/

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    @Serial
    private static final long serialVersionUID = 1L;

    private final User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, List.of(user.getRole()));
        this.user = user;
    }

    public int getId() {
        return Objects.requireNonNull(user.getId());
    }
}
