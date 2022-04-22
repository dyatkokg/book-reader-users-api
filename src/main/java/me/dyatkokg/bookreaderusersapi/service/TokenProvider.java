package me.dyatkokg.bookreaderusersapi.service;

import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.User;

public interface TokenProvider {

    TokenDTO provideToken(User user);

    boolean isTokenValid(String token);

}
