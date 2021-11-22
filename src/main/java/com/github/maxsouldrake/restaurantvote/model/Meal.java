package com.github.maxsouldrake.restaurantvote.model;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:56
 **/

public class Meal extends AbstractBaseEntity {
    private String title;
    private long price;

    public Meal(Integer id, String title, long price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public Meal(String title, long price) {
        this(null, title, price);
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

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
