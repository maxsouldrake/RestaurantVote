package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class VoteServiceTest {
    @Autowired
    private VoteService voteService;

    @Test
    void get() {
        assertEquals(voteService.get(VOTE_ID, USER_ID), user1vote1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> voteService.get(NOT_FOUND_ID, USER_ID));
    }

    @Test
    void getNotOwn() {
        assertThrows(NotFoundException.class, () -> voteService.get(VOTE_ID, USER_ID + 1));
    }


    @Test
    void create() {
        Vote newVote = getNew(Vote.class);
        Vote created = voteService.create(getNew(Vote.class), USER_ID);
        Integer newId = created.getId();
        newVote.setId(newId);
        assertEquals(created, newVote);
        assertEquals(voteService.get(newId, USER_ID), newVote);
    }

    @Test
    void duplicateDateCreate() {
        assertThrows(DataAccessException.class, () ->
                voteService.create(new Vote(null, user1, restaurant1,
                        LocalDate.of(2020,1,31)), USER_ID));
    }

    @Test
    void update() {
        Vote updated = voteService.update(getUpdated(Vote.class), USER_ID);
        assertEquals(voteService.get(VOTE_ID, USER_ID), updated);
    }

    @Test
    void updateNotOwn() {
        assertThrows(NotFoundException.class, () -> voteService.update(getUpdated(Vote.class), USER_ID + 1));
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> voteService.delete(VOTE_ID, USER_ID));
        assertThrows(NotFoundException.class, () -> voteService.get(VOTE_ID, USER_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> voteService.delete(NOT_FOUND_ID, USER_ID));
    }

    @Test
    void deleteNotOwn() {
        assertThrows(NotFoundException.class, () -> voteService.delete(VOTE_ID, USER_ID + 1));
    }
}