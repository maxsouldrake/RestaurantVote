package com.github.maxsouldrake.restaurantvote.repository;

import com.github.maxsouldrake.restaurantvote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SoulDrake
 * @create 2021-11-22 20:58
 **/

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
