package me.dyatkokg.bookreaderusersapi.service;

import me.dyatkokg.bookreaderusersapi.dto.LoginDTO;
import me.dyatkokg.bookreaderusersapi.dto.RegisterDTO;
import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.User;

public interface UserService {

    User register(RegisterDTO user);

    TokenDTO login(LoginDTO login);
}
