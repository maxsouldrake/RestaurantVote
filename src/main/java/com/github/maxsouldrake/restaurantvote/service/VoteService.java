package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.repository.RestaurantRepository;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;
import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkTimeLate;

/**
 * @author SoulDrake
 * @create 2021-12-07 15:00
 **/

@Service
@Transactional(readOnly = true)
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote get(int userId) {
        LocalDate date = LocalDate.now();
        return checkNotFound(voteRepository.findByUserIdAndDate(userId, date), userId, date);
    }

    public Vote getWithRestaurant(int userId) {
        LocalDate date = LocalDate.now();
        return checkNotFound(voteRepository.findWithRestaurant(userId,date), userId, date);
    }

    @Transactional
    public Vote update(Vote vote, int userId, int restaurantId) {
        checkTimeLate();
        LocalDate date = LocalDate.now();
        vote.setUser(userRepository.getById(userId));
        vote.setRestaurant(restaurantRepository.getById(restaurantId));
        checkNotFound(get(userId), userId, date);
        return voteRepository.save(vote);
    }

    @Transactional
    public Vote create(Vote vote, int userId, int restaurantId) {
        vote.setUser(userRepository.getById(userId));
        vote.setRestaurant(restaurantRepository.getById(restaurantId));
        return voteRepository.save(vote);
    }

    @Transactional
    public void delete(int userId) {
        checkTimeLate();
        LocalDate date = LocalDate.now();
        checkNotFound(voteRepository.deleteByUserIdAndDate(userId, date) != 0, userId, date);
    }
}
