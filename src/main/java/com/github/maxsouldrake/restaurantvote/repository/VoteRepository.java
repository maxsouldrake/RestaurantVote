package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SoulDrake
 * @create 2021-12-07 13:54
 **/

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
