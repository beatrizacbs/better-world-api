/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 16:15
 */
package br.com.betterworld.repositories;

import br.com.betterworld.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}