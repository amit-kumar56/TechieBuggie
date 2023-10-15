package com.example.apigateway.service;

import com.example.apigateway.dto.InterviewDto;
import com.example.apigateway.mapper.InterviewMapper;
import com.example.apigateway.mapper.jobMapper;
import com.example.apigateway.model.Interview;
import com.example.apigateway.model.job;
import com.example.apigateway.repository.InterviewRepository;
import com.example.apigateway.repository.jobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class InterviewServiceImpl implements InterviewService{


    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    InterviewMapper interviewMapper;

    @Override
    public List<InterviewDto> getInterview() {
        List<Interview> interviews = interviewRepository.findAll();
        return interviewMapper.toInterviewDtos(interviews);
    }

    @Override
    public InterviewDto findById(String id) {
        Optional<Interview> interview = interviewRepository.findById(id);
        if(!interview.isPresent())
            return null;
        return interviewMapper.toInterviewDto(interview.get());
    }

    @Override
    public List<InterviewDto> findByType(String type) {
        List<Interview> interview = interviewRepository.findByType(type);

        return interviewMapper.toInterviewDtos(interview);
    }

    @Override
    public InterviewDto addInterview(InterviewDto interviewDto) {
        Interview interview = interviewMapper.toInterview(interviewDto);
        interview = interviewRepository.save(interview);
        return interviewDto;
    }

    @Override
    public InterviewDto editInterview(InterviewDto interviewDto) {
        if(findById(interviewDto.getId()) == null)
            return null;
        Interview updatedInterview = interviewRepository.save(interviewMapper.toInterview(interviewDto));
        return interviewMapper.toInterviewDto(updatedInterview);
    }

    @Override
    public void deleteInterview(String id) {
        interviewRepository.deleteById(id);
    }
}
