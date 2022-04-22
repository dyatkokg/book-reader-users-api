package me.dyatkokg.bookreaderusersapi.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.bookreaderusersapi.exception.UserAlreadyExistException;
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
}
