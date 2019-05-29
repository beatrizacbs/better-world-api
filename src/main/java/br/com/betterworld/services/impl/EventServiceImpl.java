/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 15:05
 */
package br.com.betterworld.services.impl;

import br.com.betterworld.models.Event;
import br.com.betterworld.repositories.EventRepository;
import br.com.betterworld.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createOrUpdate(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public void delete(String id) {
        this.eventRepository.delete(id);
    }

    @Override
    public Event findById(String id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Page<Event> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return eventRepository.findAll(pages);
    }


}
