package me.dyatkokg.bookreaderusersapi.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.dto.LoginDTO;
import me.dyatkokg.bookreaderusersapi.dto.RegisterDTO;
import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.exception.PasswordInvalidException;
import me.dyatkokg.bookreaderusersapi.exception.UserAlreadyExistException;
import me.dyatkokg.bookreaderusersapi.exception.UserNotFoundException;
import me.dyatkokg.bookreaderusersapi.repository.UserRepository;
import me.dyatkokg.bookreaderusersapi.service.TokenProvider;
import me.dyatkokg.bookreaderusersapi.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final TokenProvider provider;

    @Override
    public User register(RegisterDTO user) {
        final String rawPassword = user.getPassword();
        final String encoded = passwordEncoder.encode(rawPassword);

        if (repository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistException();
        }

        return repository.save(User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(encoded)
                .build());
    }

    @Override
    public TokenDTO login(LoginDTO login) {
        User user = repository.findByEmail(login.getEmail()).orElseThrow(UserNotFoundException::new);
        boolean isPasswordValid = passwordEncoder.matches(login.getPassword(), user.getPassword());
        if (isPasswordValid) {
            return provider.provideToken(user);
        } else {
            throw new PasswordInvalidException();
        }
    }
}
