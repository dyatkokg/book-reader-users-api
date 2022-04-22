package me.dyatkokg.bookreaderusersapi.repository;

import me.dyatkokg.bookreaderusersapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findById(String id);

    boolean existsByEmail(String email);


}
