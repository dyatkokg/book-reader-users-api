package me.dyatkokg.bookreaderusersapi.exception;

public class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException() {
        super("Invalid password");
    }

}
