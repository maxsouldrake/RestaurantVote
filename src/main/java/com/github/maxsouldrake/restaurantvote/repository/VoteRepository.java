package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * @author SoulDrake
 * @create 2021-12-07 13:54
 **/

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Vote findByUserIdAndDate(int user_id, LocalDate date);
    int deleteByUserIdAndDate(int user_id, LocalDate date);
}
