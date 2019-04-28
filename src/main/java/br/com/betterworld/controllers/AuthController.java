/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:00
 */
package br.com.betterworld.controllers;

import br.com.betterworld.auth.AuthenticationRequest;
import br.com.betterworld.auth.JwtTokenProvider;
import br.com.betterworld.auth.RegisterRequest;
import br.com.betterworld.exceptions.EmailAlreadyRegisteredException;
import br.com.betterworld.models.User;
import br.com.betterworld.repositories.UserRepository;
import br.com.betterworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService users;

    @PostMapping("/signin")
    public ResponseEntity signin(@Valid @RequestBody AuthenticationRequest data, HttpServletResponse response) {

        try {
            String email = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            User user = users.get(email);

            List<String> roles = new ArrayList<>();
            user.getRoles().forEach(role->roles.add(role.getAuthority()));

            String token = jwtTokenProvider.createToken(email, roles);
            response.addHeader("Authorization", "Bearer "+token);

            return ResponseEntity.ok().body(null);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody RegisterRequest data, HttpServletResponse response){
        try {
            users.createUserAccount(data);
            return ResponseEntity.ok().body(users);
        } catch (EmailAlreadyRegisteredException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}