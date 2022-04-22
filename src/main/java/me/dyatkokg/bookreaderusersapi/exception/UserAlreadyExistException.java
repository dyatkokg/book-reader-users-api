package me.dyatkokg.bookreaderusersapi.exception;

public class UserAlreadyExistException extends RuntimeException{


    public UserAlreadyExistException() {
        super("User with this email already exists");
    }
}
