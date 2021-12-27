package com.github.maxsouldrake.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:58
 **/

@Entity
@Table(name = "restaurants",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = "title",
                name = "restaurants_unique_title_idx")})
public class Restaurant extends AbstractBaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference("menu")
    private List<Meal> menu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference("restaurant-votes")
    private Set<Vote> votes;

    public Restaurant(Integer id, String title) {
        super(id);
        this.title = title;
    }

    public Restaurant(String title) {
        this(null, title);
    }

    public Restaurant() {
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

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
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
