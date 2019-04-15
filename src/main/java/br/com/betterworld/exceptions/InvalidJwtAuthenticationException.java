/*
 * Developed by jrafaeldesantana@gmail.com
 * Copyright (c) 14/04/19 20:07
 */
package br.com.betterworld.exceptions;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
