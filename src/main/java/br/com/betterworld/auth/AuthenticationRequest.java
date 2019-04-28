/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:05
 */

package br.com.betterworld.auth;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
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
