package com.github.maxsouldrake.restaurantvote.util;


import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import com.github.maxsouldrake.restaurantvote.util.exception.UnmodifiableVoteException;

import java.time.LocalDate;
import java.time.LocalTime;

public class ValidationUtil {
    public static <T> T checkNotFound(T object, int id) {
        checkNotFound(object != null, id);
        return object;
    }

    public static void checkNotFound(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, int userId, LocalDate date) {
        checkNotFound(object != null, userId, date);
        return object;
    }

    public static void checkNotFound(boolean found, int userId, LocalDate date) {
        checkNotFound(found, "userId=" + userId + ", date=" + date);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkTimeLate() {
        if (LocalTime.now().isBefore(LocalTime.of(11,0))) {
            throw new UnmodifiableVoteException("vote cannot be changed after 11:00");
        }
    }
}