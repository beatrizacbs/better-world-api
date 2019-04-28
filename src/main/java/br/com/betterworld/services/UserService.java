package br.com.betterworld.services;

import br.com.betterworld.models.User;

public interface UserService {
    User insert(User user);
    User get(String email);
}
