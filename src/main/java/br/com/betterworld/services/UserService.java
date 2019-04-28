package br.com.betterworld.services;

import br.com.betterworld.auth.RegisterRequest;
import br.com.betterworld.exceptions.EmailAlreadyRegisteredException;
import br.com.betterworld.models.User;

import javax.validation.Valid;

public interface UserService {
    User insert(User user);
    User get(String email);
    User createUserAccount(@Valid RegisterRequest data) throws EmailAlreadyRegisteredException;
}
