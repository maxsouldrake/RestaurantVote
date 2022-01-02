package com.github.maxsouldrake.restaurantvote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author SoulDrake
 * @create 2022-01-02 14:49
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("user1@gmail.com").password(passwordEncoder().encode("user1pass")).roles("USER").and()
                .withUser("user2@gmail.com").password(passwordEncoder().encode("user2pass")).roles("USER").and()
                .withUser("admin@gmail.com").password(passwordEncoder().encode("adminpass")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/profile/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().httpBasic();
        http.csrf().disable();
        http.logout();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
