package com.github.maxsouldrake.restaurantvote.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:55
 **/

public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
