package com.example.apigateway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class jobDto {
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
