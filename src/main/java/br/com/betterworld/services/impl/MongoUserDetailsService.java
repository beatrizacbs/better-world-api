/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 14:44
 */
package br.com.betterworld.services.impl;

import br.com.betterworld.models.User;
import br.com.betterworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}