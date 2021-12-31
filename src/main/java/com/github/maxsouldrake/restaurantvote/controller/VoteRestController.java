package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.service.VoteService;
import com.github.maxsouldrake.restaurantvote.to.VoteTo;
import com.github.maxsouldrake.restaurantvote.util.SecurityUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:13
 **/

@RestController
@RequestMapping(value = "/profile/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final VoteService voteService;

    public VoteRestController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public VoteTo get() {
        Vote vote = voteService.get(SecurityUtil.authUserId());
        return new VoteTo(vote.getId(), vote.getRestaurant().getId());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote create(@RequestBody VoteTo voteTo) {
        return voteService.create(voteTo, SecurityUtil.authUserId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote update(@RequestBody VoteTo voteTo) {
        return voteService.update(voteTo, SecurityUtil.authUserId());
    }

    @DeleteMapping
    public void delete() {
        voteService.delete(SecurityUtil.authUserId());
    }
}
