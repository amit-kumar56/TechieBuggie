package com.example.apigateway.controller;

import com.example.apigateway.dto.jobDto;
import com.example.apigateway.exceptions.JobNotFoundException;
import com.example.apigateway.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/job-service/jobs")
public class JobController
{
    @Autowired
    private jobService jobsService;

    @GetMapping(path = "")
    public ResponseEntity<List<jobDto>> getJobs()
    {
        return ResponseEntity
                .ok(jobsService.getJobs());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<jobDto> getJobDetails(@PathVariable String id)
            throws JobNotFoundException
    {
        jobDto jobsDto = jobsService.findById(id);
        if(jobsDto == null) {
            throw new JobNotFoundException("Company not found at id : " + id);
        }
        return ResponseEntity.ok(jobsDto);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> addJobs(@RequestBody jobDto jobsDto) {
        return ResponseEntity.ok(jobsService.addJob(jobsDto));
    }

    @PutMapping(path = "")
    public ResponseEntity<jobDto> editJobs(@RequestBody jobDto jobsDto)
            throws JobNotFoundException
    {
        jobDto updatedJobDto = jobsService.editJob(jobsDto);
        if(updatedJobDto == null) {
            throw new JobNotFoundException("Company not found at id : " + jobsDto.getId());
        }
        return ResponseEntity.ok(updatedJobDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteJob(@PathVariable String id) {
        jobsService.deleteJob(id);
    }

}