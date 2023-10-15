package com.example.apigateway.service;


import com.example.apigateway.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {
    public Role addRole(Role role);
}
