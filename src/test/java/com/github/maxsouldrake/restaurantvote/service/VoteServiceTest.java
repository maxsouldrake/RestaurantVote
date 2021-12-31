package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.to.VoteTo;
import com.github.maxsouldrake.restaurantvote.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.github.maxsouldrake.restaurantvote.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class VoteServiceTest {
    @Autowired
    private VoteService voteService;

    @Test
    void get() {
        assertEquals(voteService.get(USER_ID), user1TodayVote);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> voteService.get(USER_ID + 2));
    }

    @Test
    void create() {
        Vote newVote = getNew(Vote.class);
        VoteTo voteTo = new VoteTo(newVote.getRestaurant().getId());
        Vote created = voteService.create(voteTo, USER_ID + 1);
        Integer newId = created.getId();
        newVote.setId(newId);
        assertEquals(created, newVote);
        assertEquals(voteService.get(USER_ID + 1), newVote);
    }

    @Test
    void duplicateDateCreate() {
        assertThrows(DataAccessException.class, () ->
                voteService.create(new VoteTo(RESTAURANT_ID), USER_ID));
    }

    @Test
    void update() {
        Vote updatedVote = getUpdated(Vote.class);
        VoteTo voteTo = new VoteTo(updatedVote.getId(), updatedVote.getRestaurant().getId());
        Vote updated = voteService.update(voteTo, USER_ID);
        assertEquals(voteService.get(USER_ID), updated);
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> voteService.delete(USER_ID));
        assertThrows(NotFoundException.class, () -> voteService.get(USER_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> voteService.delete(USER_ID + 2));
    }
}