package br.com.betterworld.services;

import br.com.betterworld.models.Event;
import org.springframework.data.domain.Page;

public interface EventService {

    Event createOrUpdate(Event user);

    Event findById(String id);

    void delete(String id);

    Page<Event> findAll(int page, int count);
}
