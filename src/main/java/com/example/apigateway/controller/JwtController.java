package com.example.apigateway.controller;

import com.example.apigateway.model.JwtRequest;
import com.example.apigateway.model.JwtResponse;
import com.example.apigateway.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.print(jwtRequest.getUserName());
        return jwtService.createJwtToken(jwtRequest);
    }
}