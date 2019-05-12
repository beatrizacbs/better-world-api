/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 16:15
 */
package br.com.betterworld.repositories;

import br.com.betterworld.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findRoleByRole(String role);
}