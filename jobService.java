package com.example.apigateway.service;


import com.example.apigateway.dto.jobDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface jobService {
    public List<jobDto> getJobs();
    public jobDto findById(String id);
    public jobDto addJob(jobDto jobsDto);
    public jobDto editJob(jobDto jobsDto);
    public void deleteJob(String id);
}
