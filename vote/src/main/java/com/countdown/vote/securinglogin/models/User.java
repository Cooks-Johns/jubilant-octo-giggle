package com.countdown.vote.securinglogin.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Table;
import java.util.Collection;

@EntityScan
@Table(name="users")
public abstract class User {

    public abstract Collection<? extends GrantedAuthority> geAuthorities();
}
