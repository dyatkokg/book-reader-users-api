package me.dyatkokg.bookreaderusersapi.service.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.service.TokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenProviderImplementation implements TokenProvider {

    @Value("${token.signature}")
    private String signature;

    public String generateToken(User user) {
        Date currentDate = new Date();
        Date expireAt = new Date(currentDate.getTime() + (30 * 60000));

        return JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(expireAt)
                .withIssuer("book-app")
                .withSubject(user.getId())
                .withJWTId(UUID.randomUUID().toString())
                .sign(Algorithm.HMAC256(signature));
    }

}
