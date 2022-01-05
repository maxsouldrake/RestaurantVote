package com.github.maxsouldrake.restaurantvote.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hsqldb.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SoulDrake
 * @create 2021-12-12 15:13
 **/

@Configuration
public class AppConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server hsqldbServer() {
        return new Server();
    }

    @Bean
    Module module() {
        return new Hibernate5Module();
    }
}
