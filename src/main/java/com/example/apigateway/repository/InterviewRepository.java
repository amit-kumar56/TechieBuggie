package com.example.apigateway.repository;


import com.example.apigateway.model.Interview;
import com.example.apigateway.model.job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface InterviewRepository extends MongoRepository<Interview, String> {
    public Optional<Interview> findById(String id);
    public List<Interview> findByType(String type);
}
