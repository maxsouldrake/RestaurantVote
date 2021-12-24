package com.github.maxsouldrake.restaurantvote.util.exception;

/**
 * @author SoulDrake
 * @create 2021-12-23 12:24
 **/

public class UnmodifiableVoteException extends RuntimeException{
    public UnmodifiableVoteException(String message) {
        super(message);
    }
}
