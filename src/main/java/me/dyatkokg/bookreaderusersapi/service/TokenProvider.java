package me.dyatkokg.bookreaderusersapi.service;

import me.dyatkokg.bookreaderusersapi.entity.User;

public interface TokenProvider {

    String generateToken(User user);

}
