package com.fresherway.fresherway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.JobRequest;
import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public String createJob(
            @RequestBody JobRequest request) {

        return jobService.createJob(request);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(
            @PathVariable Long id) {

        return jobService.getJobById(id);
    }
}