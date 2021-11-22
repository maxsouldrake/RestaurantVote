package com.github.maxsouldrake.restaurantvote.model;

import java.time.LocalDate;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:56
 **/

public class Meal extends AbstractBaseEntity {
    private String title;
    private long price;
    private LocalDate date;

    public Meal(Integer id, String title, long price, LocalDate date) {
        super(id);
        this.title = title;
        this.price = price;
        this.date = date;
    }

    public Meal(String title, long price, LocalDate date) {
        this(null, title, price, date);
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

    public void setDate(LocalDate date) {
        this.date = date;
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
