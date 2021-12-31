package com.github.maxsouldrake.restaurantvote.to;

/**
 * @author SoulDrake
 * @create 2021-12-29 14:37
 **/

public class VoteTo {
    private Integer id;
    private Integer restaurantId;

    public VoteTo() {
    }

    public VoteTo(Integer restaurantId) {
        this(null, restaurantId);
    }

    public VoteTo(Integer id, Integer restaurantId) {
        this.id = id;
        this.restaurantId = restaurantId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
