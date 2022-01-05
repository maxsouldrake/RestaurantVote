package com.github.maxsouldrake.restaurantvote.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

/**
 * @author SoulDrake
 * @create 2022-01-04 12:11
 **/

@SpringBootTest
@Sql(scripts = "classpath:data.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public abstract class AbstractServiceTest {
}
