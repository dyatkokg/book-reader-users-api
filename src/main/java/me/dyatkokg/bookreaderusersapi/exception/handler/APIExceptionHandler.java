package me.dyatkokg.bookreaderusersapi.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.bookreaderusersapi.exception.PasswordInvalidException;
import me.dyatkokg.bookreaderusersapi.exception.UserAlreadyExistException;
import me.dyatkokg.bookreaderusersapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserExist(UserAlreadyExistException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User with this email already exists");
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this email was not found. Try again!");
    }

    @ExceptionHandler({PasswordInvalidException.class})
    public ResponseEntity<Object> handleInvalidPassword(PasswordInvalidException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password. Try again!");
    }
}
