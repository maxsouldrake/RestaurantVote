package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.repository.VoteRepository;
import org.springframework.stereotype.Service;

/**
 * @author SoulDrake
 * @create 2021-12-07 15:00
 **/

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }

    public Vote get(int id, int userId) {
        return voteRepository.findByIdAndUserId(id, userId);
    }

    public Vote update(Vote vote, int userId) {
        vote.setUser(userRepository.getById(userId));
        return voteRepository.save(vote);
    }

    public Vote create(Vote vote, int userId) {
        vote.setUser(userRepository.getById(userId));
        return voteRepository.save(vote);
    }

    public void delete(int id, int userId) {
        voteRepository.deleteByIdAndUserId(id, userId);
    }
}
