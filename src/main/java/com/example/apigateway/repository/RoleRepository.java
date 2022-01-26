package com.example.apigateway.repository;


import com.example.apigateway.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface RoleRepository extends MongoRepository<Role, String> {
    public Optional<Role> findById(String id);
}
