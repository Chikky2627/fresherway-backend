package com.fresherway.fresherway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.ApplicationRequest;
import com.fresherway.fresherway.dto.ApplicationStatus;
import com.fresherway.fresherway.entity.JobApplication;
import com.fresherway.fresherway.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    @PostMapping
    public String applyJob(
            @RequestBody ApplicationRequest request) {

        return applicationService.applyJob(request);
    }

    @GetMapping("/user/{userId}")
    public List<JobApplication> getApplications(
            @PathVariable Long userId) {

        return applicationService.getApplications(userId);
    }
    @PutMapping("/status")
public String updateStatus(
        @RequestBody
        ApplicationStatus request) {

    return applicationService.updateStatus(
            request.getApplicationId(),
            request.getStatus());
}
}