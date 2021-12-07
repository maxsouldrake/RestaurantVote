package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SoulDrake
 * @create 2021-12-07 14:57
 **/

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(int id) {
        return userRepository.findById(id).get();
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
