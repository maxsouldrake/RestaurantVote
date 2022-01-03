package com.github.maxsouldrake.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:59
 **/

@Entity
@Table(name = "votes",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"user_id", "date"},
                name = "votes_unique_date_user_idx")})
public class Vote extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference("user-votes")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference("restaurant-votes")
    private Restaurant restaurant;

    @Column(name = "date", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final LocalDate date = LocalDate.now();

    public Vote(Integer id, Restaurant restaurant) {
        super(id);
        this.restaurant = restaurant;
    }

    public Vote(Restaurant restaurant) {
        this(null, restaurant);
    }

    public Vote() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", user=" + user +
                ", restaurant=" + restaurant +
                ", date=" + date +
                '}';
    }
}
