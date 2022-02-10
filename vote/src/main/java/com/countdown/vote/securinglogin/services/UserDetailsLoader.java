package com.countdown.vote.securinglogin.services;

import com.countdown.vote.securinglogin.models.User;
import com.countdown.vote.securinglogin.models.UserWithRoles;
import com.countdown.vote.securinglogin.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepo users;

    public UserDetailsLoader(UserRepo users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "There is now user for {}" + username);
        }
        return new UserWithRoles(user);
    }



}
