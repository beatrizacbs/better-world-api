/*
 * Developed by beatrizacbs@gmail.com
 * Copyright (c) 08/04/19 23:23
 */

package br.com.betterworld.repositories;

import br.com.betterworld.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByEmail(String email);
}
