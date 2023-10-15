package com.example.apigateway.service;


import com.example.apigateway.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public User addUser(User user);
    public void initRoleAndUser();
}
