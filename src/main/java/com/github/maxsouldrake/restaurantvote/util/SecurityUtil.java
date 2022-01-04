package com.github.maxsouldrake.restaurantvote.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;


public class SecurityUtil {
//
//    private SecurityUtil() {
//    }

    public static int authUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = Objects.requireNonNull(auth.getPrincipal());
        AuthorizedUser authorizedUser = (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
        return Objects.requireNonNull(authorizedUser, "No authorized user found").getId();
    }

}