package com.example.apigateway.mapper;

import com.example.apigateway.dto.jobDto;
import com.example.apigateway.model.job;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class jobMapper {
    public jobDto toJobDto(job job)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        jobDto jobDto = mapper.map(job, jobDto.class);
        return jobDto;
    }

    public job toJob(jobDto jobDto)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        job job = mapper.map(jobDto, job.class);
        return job;
    }

    public List<jobDto> toJobDtos(List<job> jobs)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<jobDto> jobDtos = Arrays.asList(mapper.map(jobs, jobDto[].class));
        return jobDtos;
    }
}
