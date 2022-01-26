package com.example.apigateway.controller;


import com.example.apigateway.dto.InterviewDto;
import com.example.apigateway.exceptions.JobNotFoundException;
import com.example.apigateway.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/interview-service/questions")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;


    @GetMapping(path = "")
    public ResponseEntity<List<InterviewDto>> getInterviews()
    {
        return ResponseEntity
                .ok(interviewService.getInterview());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InterviewDto> getInterviewDetails(@PathVariable String id)
            throws JobNotFoundException
    {
        InterviewDto interviewDto = interviewService.findById(id);
        if(interviewDto == null) {
            throw new JobNotFoundException("Company not found at id : " + id);
        }
        return ResponseEntity.ok(interviewDto);
    }
    @GetMapping(path = "/type/{type}")
    public ResponseEntity<List<InterviewDto>> getInterviewDetailsBYType(@PathVariable String type)
            throws JobNotFoundException
    {

        List<InterviewDto> interviewDto = interviewService.findByType(type);
        if(interviewDto == null) {
            throw new JobNotFoundException("Company not found at id : " + type);
        }
        return ResponseEntity.ok(interviewDto);
    }
    @PostMapping(path = "")
    public ResponseEntity<?> addInterviews(@RequestBody InterviewDto interviewDto) {
        return ResponseEntity.ok(interviewService.addInterview(interviewDto));
    }

    @PutMapping(path = "")
    public ResponseEntity<InterviewDto> editInterviews(@RequestBody InterviewDto interviewDto)
            throws JobNotFoundException
    {
        InterviewDto updatedInterviewDto = interviewService.editInterview(interviewDto);
        if(updatedInterviewDto == null) {
            throw new JobNotFoundException("Company not found at id : " + interviewDto.getId());
        }
        return ResponseEntity.ok(updatedInterviewDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteJob(@PathVariable String id) {
        interviewService.deleteInterview(id);
    }
}
