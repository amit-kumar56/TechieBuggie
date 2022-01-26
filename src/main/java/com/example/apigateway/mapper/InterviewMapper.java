package com.example.apigateway.mapper;

import com.example.apigateway.dto.InterviewDto;
import com.example.apigateway.model.Interview;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InterviewMapper {
    public InterviewDto toInterviewDto(Interview interview)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        InterviewDto interviewDto = mapper.map(interview, InterviewDto.class);
        return interviewDto;
    }

    public Interview toInterview(InterviewDto interviewDto)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Interview interview = mapper.map(interviewDto, Interview.class);
        return interview;
    }

    public List<InterviewDto> toInterviewDtos(List<Interview> interviews)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<InterviewDto> interviewDtos = Arrays.asList(mapper.map(interviews, InterviewDto[].class));
        return interviewDtos;
    }
}
