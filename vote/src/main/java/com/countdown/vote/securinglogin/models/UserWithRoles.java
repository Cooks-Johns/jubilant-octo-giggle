package com.countdown.vote.securinglogin.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails {

    public UserWithRoles(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> geAuthorities() {
        String roles = "";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

// Todo
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

// Todo
    @Override
    public String getPassword() {
        return null;
    }

// Todo
    @Override
    public String getUsername() {
        return null;
    }

// Using
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

// Using
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

// Using
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

// Using
    @Override
    public boolean isEnabled() {
        return true;
    }
}
