package com.github.maxsouldrake.restaurantvote.config;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.util.AuthorizedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author SoulDrake
 * @create 2022-01-02 14:49
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return email -> {
            User user = userRepository.findByEmail(email.toLowerCase());
            if (user == null) {
                throw new UsernameNotFoundException("User " + email + " is not found");
            }
            return new AuthorizedUser(user);
        };
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/restaurant-vote/login").permitAll()
                .antMatchers(HttpMethod.POST, "/restaurant-vote/profile").anonymous()
                .antMatchers("/restaurant-vote/profile/**").hasRole("USER")
                .antMatchers("/restaurant-vote/admin/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .formLogin().loginPage("/restaurant-vote/login")
                .and().logout().logoutSuccessUrl("/restaurant-vote/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
