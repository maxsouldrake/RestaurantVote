package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.service.VoteService;
import com.github.maxsouldrake.restaurantvote.to.VoteTo;
import com.github.maxsouldrake.restaurantvote.util.AuthorizedUser;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:13
 **/

@RestController
@RequestMapping(value = "/restaurant-vote/profile/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final VoteService voteService;

    public VoteRestController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public VoteTo get(@Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authUser) {
        Vote vote = voteService.get(authUser.getId());
        return new VoteTo(vote.getId(), vote.getRestaurant().getId());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote create(@RequestBody VoteTo voteTo, @Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authUser) {
        return voteService.create(voteTo, authUser.getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote update(@RequestBody VoteTo voteTo, @Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authUser) {
        return voteService.update(voteTo, authUser.getId());
    }

    @DeleteMapping
    public void delete(@Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authUser) {
        voteService.delete(authUser.getId());
    }
}
