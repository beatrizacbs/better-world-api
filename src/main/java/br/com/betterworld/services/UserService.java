/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 14:46
 */
package br.com.betterworld.services;

import br.com.betterworld.models.User;
import br.com.betterworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User get(String email){ return userRepository.findByEmail(email);}
}
