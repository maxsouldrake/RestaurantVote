package com.github.maxsouldrake.restaurantvote.util;

import com.github.maxsouldrake.restaurantvote.model.AbstractBaseEntity;

public class SecurityUtil {

    private SecurityUtil() {
    }

    // TODO implement authentication
    public static int authUserId() {
        return AbstractBaseEntity.START_SEQ;
    }

}