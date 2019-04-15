/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 15:05
 */
package br.com.betterworld.services;

import br.com.betterworld.models.Role;
import br.com.betterworld.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role insert(Role role){return roleRepository.insert(role);}
}
