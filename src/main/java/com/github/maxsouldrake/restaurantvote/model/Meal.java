package com.github.maxsouldrake.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:56
 **/

@Entity
@Table(name = "meals",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"restaurant_id", "title", "date"},
                name = "meals_unique_restaurant_title_date_idx")})
public class Meal extends AbstractBaseEntity {
    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String title;

    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 1_000_000)
    private long price;

    @Column(name = "date", nullable = false)
    private final LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference("menu")
    private Restaurant restaurant;

    public Meal(Integer id, String title, long price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public Meal(String title, long price) {
        this(null, title, price);
    }

    public Meal() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
