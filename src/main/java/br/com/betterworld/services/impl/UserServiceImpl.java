/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 14:46
 */
package br.com.betterworld.services.impl;

import br.com.betterworld.auth.RegisterRequest;
import br.com.betterworld.exceptions.EmailAlreadyRegisteredException;
import br.com.betterworld.models.User;
import br.com.betterworld.repositories.RoleRepository;
import br.com.betterworld.repositories.UserRepository;
import br.com.betterworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User insert(User user){

        return userRepository.insert(user);
    }

    public User get(String email){ return userRepository.findByEmail(email);}

    public User createUserAccount(@Valid RegisterRequest data) throws EmailAlreadyRegisteredException {
        User exists = userRepository.findByEmail(data.getEmail());

        if(exists != null){
            throw new EmailAlreadyRegisteredException("E-mail already registered");
        }

        User user = new User();
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        LocalDate birthDate = LocalDate.parse(data.getBirthdate());
        user.setBirthDate(birthDate);

        //Set all new users as user role
        Set<GrantedAuthority> role = new HashSet<>();
        role.add(roleRepository.findRoleByRole("ROLE_USER"));
        user.setRoles(role);

        return userRepository.insert(user);
    }
}
