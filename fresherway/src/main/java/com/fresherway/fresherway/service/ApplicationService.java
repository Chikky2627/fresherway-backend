package com.fresherway.fresherway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.ApplicationRequest;
import com.fresherway.fresherway.entity.JobApplication;
import com.fresherway.fresherway.repository.JobApplicationRepository;

@Service
public class ApplicationService {

    private final JobApplicationRepository applicationRepository;

    public ApplicationService(
            JobApplicationRepository applicationRepository) {

        this.applicationRepository = applicationRepository;
    }

    public String applyJob(ApplicationRequest request) {

        JobApplication application =
                new JobApplication();

        application.setUserId(request.getUserId());
        application.setJobId(request.getJobId());
        application.setStatus("APPLIED");

        applicationRepository.save(application);

        return "Applied Successfully";
    }

    public List<JobApplication> getApplications(
            Long userId) {

        return applicationRepository.findByUserId(userId);
    }
}