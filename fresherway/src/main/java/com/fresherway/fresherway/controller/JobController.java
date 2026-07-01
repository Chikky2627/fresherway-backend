package com.fresherway.fresherway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.JobRequest;
import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.service.JobService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public String createJob(
        @Valid
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
    @GetMapping("/search/skill")
public List<Job> searchBySkill(
        @RequestParam String skill) {

    return jobService.searchBySkill(skill);
}

@GetMapping("/search/location")
public List<Job> searchByLocation(
        @RequestParam String location) {

    return jobService.searchByLocation(location);
}

@GetMapping("/search/company")
public List<Job> searchByCompany(
        @RequestParam String company) {

    return jobService.searchByCompany(company);
}
@GetMapping("/search")
public List<Job> searchJobs(
        @RequestParam(required = false) String skill,
        @RequestParam(required = false) String location) {

    if (skill != null && location != null) {
        return jobService.searchBySkillAndLocation(skill, location);
    }

    if (skill != null) {
        return jobService.searchBySkill(skill);
    }

    if (location != null) {
        return jobService.searchByLocation(location);
    }

    return jobService.getAllJobs();
}
@GetMapping("/fake")
public List<Job> getFakeJobs() {

    return jobService.getFakeJobs();

}
@DeleteMapping("/{id}")
public String deleteJob(
        @PathVariable Long id){

    return jobService.deleteJob(id);

}
}