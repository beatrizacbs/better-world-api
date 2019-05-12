/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 15:05
 */
package br.com.betterworld.services.impl;

import br.com.betterworld.models.Role;
import br.com.betterworld.repositories.RoleRepository;
import br.com.betterworld.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role insert(Role role){return roleRepository.insert(role);}
}
