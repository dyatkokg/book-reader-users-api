package me.dyatkokg.bookreaderusersapi.service.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import me.dyatkokg.bookreaderusersapi.entity.User;
import me.dyatkokg.bookreaderusersapi.service.TokenProvider;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenProviderImplementation implements TokenProvider {

    private static final String SIGNATURE = "x7HktL7QmQwR7Ii98AU3eACZ70arilFhCIgz54IYEOMCL0UIl7MWCBXeEzyQ6syQmWXWJACQzOWkrWd2DBnibCbENjd6fV7m073e27KkERwBSrmSX0hv28P8rP6LSXY1xs24Fr6w3Se7amJ9fRSPfIL0cXdujrtUUPjPp8M1M6SKJezzOMkSKZtihTKRscQrBjcTPJWs";

    public String generateToken(User user) {
        Date currentDate = new Date();
        Date expireAt = new Date(currentDate.getTime() + (30 * 60000));

        return JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(expireAt)
                .withIssuer("book-app")
                .withSubject(user.getEmail())
                .withJWTId(UUID.randomUUID().toString())
                .sign(Algorithm.HMAC256(SIGNATURE));
    }

}
