package br.com.betterworld.controllers;

import br.com.betterworld.models.Event;
import br.com.betterworld.response.Response;
import br.com.betterworld.security.entity.User;
import br.com.betterworld.services.EventService;
import br.com.betterworld.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{page}/{count}")
    public ResponseEntity<Response<Page<Event>>> findAll(@PathVariable int page, @PathVariable int count) {

        Response<Page<Event>> response = new Response<>();
        Page<Event> events = this.eventService.findAll(page, count);
        response.setData(events);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<Event>> findById(@PathVariable("id") String id) {
        Response<Event> response = new Response<>();
        Event event = this.eventService.findById(id);
        if (event == null) {
            response.getErros().add("Event not found id: " + id);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        response.setData(event);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Response<Event>> create(@RequestBody Event event,
                                                  BindingResult result) {
        Response<Event> response = new Response<>();
        try {
            validateCreateEvent(event, result);
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
                return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
            }
            event = eventService.createOrUpdate(event);
            response.setData(event);
        } catch (Exception e) {
            response.getErros().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    private void validateCreateEvent(Event event, BindingResult result) {
        if (event.getTitle() == null) {
            result.addError(new ObjectError("Event", "Title no information"));
        }
        //Add novos erros
    }

    @PutMapping()
    public ResponseEntity<Response<Event>> update(@RequestBody Event event, BindingResult result) {
        Response<Event> response = new Response<>();
        try {
            validateUpdate(event, result);
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
                return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
            }
            event = eventService.createOrUpdate(event);
            response.setData(event);
        } catch (Exception e) {
            response.getErros().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    private void validateUpdate(Event event, BindingResult result) {
        if (event.getId() == null) {
            result.addError(new ObjectError("Event", "Id no information"));
        }
        if (event.getTitle() == null) {
            result.addError(new ObjectError("User", "Title no information"));
        }
        //Add novos erros
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
        Response<String> response = new Response<>();
        Event event = eventService.findById(id);
        if (event == null) {
            response.getErros().add("Register not found id:" + id);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        eventService.delete(id);
        return ResponseEntity.ok(new Response<>());
    }

    @PostMapping(value = "/getIN/{idEvent}/{idUSer}")
    public ResponseEntity<Response> getIN(@PathVariable String idEvent, @PathVariable String idUSer){
        Response<String> response = new Response<>();
        Event event = eventService.findById(idEvent);

        if (event == null){
            response.getErros().add("Event not found");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        User user = userService.findById(idUSer);

        if (user == null){
            response.getErros().add("User not found");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        event.getParticipants().add(idUSer);
        eventService.createOrUpdate(event);
        response.setData("User included no event");
        return  ResponseEntity.ok(response);
    }
}
