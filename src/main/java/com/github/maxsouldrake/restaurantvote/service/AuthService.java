package com.github.maxsouldrake.restaurantvote.service;

import com.github.maxsouldrake.restaurantvote.model.User;
import com.github.maxsouldrake.restaurantvote.repository.UserRepository;
import com.github.maxsouldrake.restaurantvote.util.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author SoulDrake
 * @create 2022-01-03 19:29
 **/

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
