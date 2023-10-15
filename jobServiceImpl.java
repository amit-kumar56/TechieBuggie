package com.example.apigateway.service;

import com.example.apigateway.dto.jobDto;
import com.example.apigateway.model.job;
import com.example.apigateway.repository.jobRepository;
 import com.example.apigateway.mapper.jobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
@Service
public class jobServiceImpl implements jobService {

    @Autowired
    jobRepository jobRepository;

    @Autowired
    jobMapper  jobMapper;

    @Override
    public List<jobDto> getJobs() {
        List<job> jobs = jobRepository.findAll();
        return jobMapper.toJobDtos(jobs);
    }

    @Override
    public jobDto findById(String id) {
        Optional<job> company = jobRepository.findById(id);
        if(!company.isPresent())
            return null;
        return jobMapper.toJobDto(company.get());
    }

    @Override
    public jobDto addJob(jobDto jobsDto) {
        job jobs = jobMapper.toJob(jobsDto);
        jobs = jobRepository.save(jobs);
        return jobsDto;
    }

    @Override
    public jobDto editJob(jobDto jobsDto) {
        if(findById(jobsDto.getId()) == null)
            return null;
        job updatedJob = jobRepository.save(jobMapper.toJob(jobsDto));
        return jobMapper.toJobDto(updatedJob);
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }
}
