package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.Restaurant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * @author SoulDrake
 * @create 2021-11-22 20:59
 **/

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByTitle(String title);

    @EntityGraph(attributePaths = {"menu", "votes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Restaurant r JOIN r.menu m JOIN r.votes v WHERE r.id =:id AND m.date=:date AND v.date=:date")
    Restaurant findWithMenuAndVotes(@Param("id") int id, @Param("date") LocalDate date);
}
