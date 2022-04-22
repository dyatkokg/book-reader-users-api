package me.dyatkokg.bookreaderusersapi.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.dto.LoginDTO;
import me.dyatkokg.bookreaderusersapi.dto.RegisterDTO;
import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.repository.UserRepository;
import me.dyatkokg.bookreaderusersapi.service.TokenProvider;
import me.dyatkokg.bookreaderusersapi.service.UserService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository repository;


    private final TokenProvider provider;

    @Override
    public User register(RegisterDTO user) {
        return null;
    }

    @Override
    public TokenDTO login(LoginDTO login) {
        return null;
    }
}
