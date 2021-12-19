package com.github.maxsouldrake.restaurantvote.controller;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.service.UserService;
import com.github.maxsouldrake.restaurantvote.util.SecurityUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author SoulDrake
 * @create 2021-12-17 18:12
 **/

@RestController
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestController {
    private final UserService userService;

    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User get() {
        return userService.get(SecurityUtil.authUserId());
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        user.setId(SecurityUtil.authUserId());
        return userService.update(user);
    }

    @DeleteMapping
    public void delete() {
        userService.delete(SecurityUtil.authUserId());
    }

}