package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.maxsouldrake.restaurantvote.util.ValidationUtil.checkNotFound;

/**
 * @author SoulDrake
 * @create 2021-12-07 15:00
 **/

@Service
@Transactional(readOnly = true)
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }

    public Vote get(int id, int userId) {
        return checkNotFound(voteRepository.findByIdAndUserId(id, userId), id);
    }

    @Transactional
    public Vote update(Vote vote, int userId) {
        vote.setUser(userRepository.getById(userId));
        checkNotFound(get(vote.getId(), userId), userId);
        return voteRepository.save(vote);
    }

    @Transactional
    public Vote create(Vote vote, int userId) {
        vote.setUser(userRepository.getById(userId));
        return voteRepository.save(vote);
    }

    @Transactional
    public void delete(int id, int userId) {
        checkNotFound(voteRepository.deleteByIdAndUserId(id, userId) != 0, id);
    }
}
