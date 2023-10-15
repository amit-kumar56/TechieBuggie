package com.example.apigateway.service;


import com.example.apigateway.dto.InterviewDto;
import com.example.apigateway.dto.jobDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InterviewService {
    public List<InterviewDto> getInterview();
    public InterviewDto findById(String id);
    public List<InterviewDto> findByType(String type);
    public InterviewDto addInterview(InterviewDto interviewDto);
    public InterviewDto editInterview(InterviewDto interviewDto);
    public void deleteInterview(String id);
}
