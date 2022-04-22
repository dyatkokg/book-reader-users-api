package me.dyatkokg.bookreaderusersapi.repository;

import me.dyatkokg.bookreaderusersapi.entity.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<Token, String> {
    Token findByValue(String value);
}
