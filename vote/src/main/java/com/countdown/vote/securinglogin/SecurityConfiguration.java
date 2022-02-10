package com.countdown.vote.securinglogin;


import com.countdown.vote.securinglogin.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

// Login configuration
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/ads") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page

// Logout configurator
            .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // Will append a query string value

/* These pages do not need a login */
            .and()
                .authorizeRequests()
                .antMatchers("/", "/ads") // anyone can see the home and ads page
                .permitAll()

    /* Pages that authentiicate users */
            .and()
                .authorizeRequests()
                .antMatchers(
                        "/ads/create",  // Only authenticated users can create ads
                        "ads/{id}/edit" // Only authenticated users can edit ads
                )
                .authenticated();
    }
}




