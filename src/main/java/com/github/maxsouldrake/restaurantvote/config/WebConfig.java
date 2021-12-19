package com.github.maxsouldrake.restaurantvote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SoulDrake
 * @create 2021-12-19 12:26
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.maxsouldrake.**.controller")
public class WebConfig implements WebMvcConfigurer {
}
