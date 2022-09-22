package com.revature.project2.common.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("Could not find a user account with the provided credentials!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

}
