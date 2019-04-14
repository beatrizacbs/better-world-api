/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:05
 */

package br.com.betterworld.auth;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
