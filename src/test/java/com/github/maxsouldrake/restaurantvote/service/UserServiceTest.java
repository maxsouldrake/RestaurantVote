package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.model.Role;
import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static com.github.maxsouldrake.restaurantvote.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void getAll() {
        assertThat(userService.getAll()).isEqualTo(List.of(user1, user2, admin));
    }

    @Test
    void get() {
        assertEquals(userService.get(USER_ID), user1);
    }

    @Test
    void getByEmail() {
        assertEquals(userService.getByEmail(USER_EMAIL), user1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> userService.get(NOT_FOUND_ID));
    }

    @Test
    void create() {
        User newUser = getNew(User.class);
        User created = userService.create(getNew(User.class));
        Integer newId = created.getId();
        newUser.setId(newId);
        assertEquals(created, newUser);
        assertEquals(userService.get(newId), newUser);
    }

    @Test
    void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                userService.create(new User(null, USER_EMAIL, "newPass", Role.USER)));
    }

    @Test
    void update() {
        User updated = userService.update(getUpdated(User.class));
        assertEquals(userService.get(USER_ID), updated);
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> userService.delete(USER_ID));
        assertThrows(NotFoundException.class, () -> userService.get(USER_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> userService.delete(NOT_FOUND_ID));
    }
}