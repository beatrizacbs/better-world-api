/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:06
 */
package br.com.betterworld.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiController {

    @GetMapping("/")
    public ResponseEntity<String> home(){
        /*CRIANDO USUARIO DE EXEMPLO

        User user = new User();
        user.setName("José Rafael de Santana");
        user.setPassword(new BCryptPasswordEncoder().encode("1234"));
        user.setEmail("jrafaeldesantana@gmail.com");
        user.setBirthDate(LocalDate.of(1997,9,14));

        Set<GrantedAuthority> roles = new HashSet<>();
        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");

        roles.add(roleService.insert(adminRole));

        user.setRoles(roles);

        userService.insert(user);*/

        return ResponseEntity.ok("Home");
    }

    @GetMapping("/secure")
    public ResponseEntity<String> secure(){
        return ResponseEntity.ok("Teste de página segura");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Somente administradores");
    }
}
