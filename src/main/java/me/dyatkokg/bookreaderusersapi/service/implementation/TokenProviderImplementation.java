package me.dyatkokg.bookreaderusersapi.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.Token;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.mapper.TokenMapper;
import me.dyatkokg.bookreaderusersapi.repository.TokenRepository;
import me.dyatkokg.bookreaderusersapi.service.TokenProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenProviderImplementation implements TokenProvider {

    private final TokenRepository repository;

    private final TokenMapper mapper;

    @Override
    public TokenDTO provideToken(User user) {
        Token token = Token.builder()
                .owner(user)
                .value(UUID.randomUUID().toString())
                .expireAt(LocalDateTime.now().plusHours(2))
                .build();

        repository.save(token);
        return mapper.toDTO(token);
    }

    @Override
    public boolean isTokenValid(String token) {
        Token dbToken = repository.findByValue(token);
        return Objects.nonNull(dbToken) && dbToken.getExpireAt().isAfter(LocalDateTime.now());
    }
}
