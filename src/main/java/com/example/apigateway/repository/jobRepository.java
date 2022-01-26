package com.example.apigateway.repository;


import com.example.apigateway.model.job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface jobRepository extends MongoRepository<job, String> {
    public Optional<job> findById(String id);
}
