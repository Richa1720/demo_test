package com.example.demo_test.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//here we've implemented UserDetailsService to load user data like username, password & granted
//authorities.
//As UserDetailsService is an interface which contains an abstract
// method loadUserByUsername() to load granted info of user


@Service
public class MyUserDetailsService implements UserDetailsService {
//User is a predefined class used for security purpose in spring boot
// withDefaultPasswordEncoder()
//here roles() method indicates role
//build() -> builds the objects and returns it or null

    @Override
    public UserDetails loadUserByUsername(String username) {
        if ("user".contains(username)) {
            return User
                    .withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

        }
        else if ("admin".contains(username)) {
            UserDetails user=User
                    .withUsername("admin")
                    .password("{noop}admin")
                    .roles("ADMIN")
                    .build();
            return user;

            // withDefaultPasswordEncoder() is mandatory to encode the password

        } else {
            return User.withUsername(username)
                    .password("{noop}password")  // Use "{noop}" for plain text passwords for testing purposes
                    .roles("USER")
                    .build();

        }
    }
}
