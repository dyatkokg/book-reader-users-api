package me.dyatkokg.bookreaderusersapi.repository;

import me.dyatkokg.bookreaderusersapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
