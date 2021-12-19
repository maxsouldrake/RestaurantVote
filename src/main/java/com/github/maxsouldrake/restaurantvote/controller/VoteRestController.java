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
@RequestMapping(value = "/profile/votes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final VoteService voteService;

    public VoteRestController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{id}")
    public Vote get(@PathVariable int id) {
        return voteService.get(id, SecurityUtil.authUserId());
    }

    @PostMapping
    public Vote create(@RequestBody Vote vote) {
        return voteService.create(vote, SecurityUtil.authUserId());
    }

    @PutMapping("/{id}")
    public Vote update(@RequestBody Vote vote,  @PathVariable int id) {
        vote.setId(id);
        return voteService.update(vote, SecurityUtil.authUserId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        voteService.delete(id, SecurityUtil.authUserId());
    }
}
