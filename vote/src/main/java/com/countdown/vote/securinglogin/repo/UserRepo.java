package com.countdown.vote.securinglogin.repo;

import com.countdown.vote.securinglogin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
