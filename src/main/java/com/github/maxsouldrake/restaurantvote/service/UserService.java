package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;

/**
 * @author SoulDrake
 * @create 2021-12-07 14:57
 **/

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(int id) {
        Optional<User> user = userRepository.findById(id);
        checkNotFound(user.isPresent(), id);
        return user.get();
    }

    public User getByEmail(String email) {
        return checkNotFound(userRepository.findByEmail(email), email);
    }

    @Transactional
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return checkNotFound(userRepository.save(user), user.getId());
    }

    @Transactional
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        checkNotFound(userRepository.existsById(id), id);
        userRepository.deleteById(id);
    }
}
