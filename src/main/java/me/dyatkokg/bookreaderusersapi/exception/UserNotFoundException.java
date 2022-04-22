package me.dyatkokg.bookreaderusersapi.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User with this email was not found");
    }

}
