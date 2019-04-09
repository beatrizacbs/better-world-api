/*
 * Developed by beatrizacbs@gmail.com
 * Copyright (c) 08/04/19 23:23
 */

package br.com.betterworld.repositories;

import br.com.betterworld.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}