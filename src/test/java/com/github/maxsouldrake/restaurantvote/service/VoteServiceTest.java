package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.model.Vote;
import com.github.maxsouldrake.restaurantvote.testdata.RestaurantTestData;
import com.github.maxsouldrake.restaurantvote.testdata.UserTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static com.github.maxsouldrake.restaurantvote.testdata.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class VoteServiceTest {
    @Autowired
    private VoteService voteService;

    @Test
    void get() {
        assertEquals(voteService.get(VOTE_ID, UserTestData.USER_ID), user1vote1);
    }

    @Test
    void getNotFound() {
    }

    @Test
    void getNotOwn() {
    }


    @Test
    void create() {
        Vote newVote = getNew();
        Vote created = voteService.create(getNew(), UserTestData.USER_ID);
        Integer newId = created.getId();
        newVote.setId(newId);
        assertEquals(created, newVote);
        assertEquals(voteService.get(newId, UserTestData.USER_ID), newVote);
    }

    @Test
    void duplicateDateCreate() {
        assertThrows(DataAccessException.class, () ->
                voteService.create(new Vote(null, UserTestData.user1, RestaurantTestData.restaurant1,
                        LocalDate.of(2020,1,31)), UserTestData.USER_ID));
    }

    @Test
    void update() {
        Vote updated = voteService.update(getUpdated(), UserTestData.USER_ID);
        assertEquals(voteService.get(VOTE_ID, UserTestData.USER_ID), updated);
    }

    @Test
    void updateNotOwn() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteNotFound() {
    }

    @Test
    void deleteNotOwn() {
    }
}