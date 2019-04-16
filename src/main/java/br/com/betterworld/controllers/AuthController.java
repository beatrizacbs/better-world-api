/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:00
 */
package br.com.betterworld.controllers;

import br.com.betterworld.auth.AuthenticationRequest;
import br.com.betterworld.auth.JwtTokenProvider;
import br.com.betterworld.models.User;
import br.com.betterworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse response) {

        try {
            String email = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            User user = this.users.findByEmail(email);

            List<String> roles = new ArrayList<>();
            user.getRoles().forEach(role->roles.add(role.getAuthority()));

            String token = jwtTokenProvider.createToken(email, roles);
            response.addHeader("Authorization", "Bearer "+token);

            return ResponseEntity.ok().body(null);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }
}