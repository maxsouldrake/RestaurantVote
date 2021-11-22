package com.github.maxsouldrake.restaurantvote.model;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:58
 **/

public class Restaurant extends AbstractBaseEntity {
    private String title;
    private List<Meal> menu;

    public Restaurant(Integer id, String title, List<Meal> menu) {
        super(id);
        this.title = title;
        this.menu = menu;
    }

    public Restaurant(String title, List<Meal> menu) {
        this(null, title, menu);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", menu=" + menu +
                '}';
    }
}
