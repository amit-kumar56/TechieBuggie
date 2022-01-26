package com.example.apigateway.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class job {
    @Id
    private String id;
    private String companyName;
    private int salary;
    private String profile;
    private String qualification;
    private String experiance;
    private String link;
    private String requirement;
    private String description;
}
