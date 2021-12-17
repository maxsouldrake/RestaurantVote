package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;

/**
 * @author SoulDrake
 * @create 2021-12-07 14:57
 **/

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found entity with id=" + id));
    }

    public User getByEmail(String email) {
        return checkNotFound(userRepository.findByEmail(email), email);
    }

    @Transactional
    public User update(User user) {
        return checkNotFound(userRepository.save(user), user.getId());
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        checkNotFound(userRepository.existsById(id), id);
        userRepository.deleteById(id);
    }
}
