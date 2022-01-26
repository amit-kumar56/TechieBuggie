package com.example.apigateway.repository;


import com.example.apigateway.model.Role;
import com.example.apigateway.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findById(String id);
}
