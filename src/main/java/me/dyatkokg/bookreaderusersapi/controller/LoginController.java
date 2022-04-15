package me.dyatkokg.bookreaderusersapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.dto.LoginDTO;
import me.dyatkokg.bookreaderusersapi.dto.RegisterDTO;
import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class LoginController {

    private final UserService service;

    @PostMapping("register")
    public User registerUser(@RequestBody RegisterDTO user) {
        return service.register(user);
    }

    @PostMapping("login")
    public TokenDTO login(@RequestBody LoginDTO login) {
        return service.login(login);
    }


}
