package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.service.VoteService;
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
    public Vote get() {
        return voteService.get(SecurityUtil.authUserId());
    }

    @PostMapping
    public Vote create(@RequestBody Vote vote, @RequestParam int restaurantId) {
        return voteService.create(vote, SecurityUtil.authUserId(), restaurantId);
    }

    @PutMapping
    public Vote update(@RequestBody Vote vote, @RequestParam int restaurantId) {
        return voteService.update(vote, SecurityUtil.authUserId(), restaurantId);
    }

    @DeleteMapping
    public void delete() {
        voteService.delete(SecurityUtil.authUserId());
    }
}
