package com.fresherway.fresherway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.entity.JobApplication;
import com.fresherway.fresherway.entity.User;
import com.fresherway.fresherway.repository.JobApplicationRepository;
import com.fresherway.fresherway.repository.JobRepository;
import com.fresherway.fresherway.repository.StudentProfileRepository;
import com.fresherway.fresherway.repository.UserRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final JobApplicationRepository applicationRepository;
    private final StudentProfileRepository profileRepository;

    public AdminService(
            UserRepository userRepository,
            JobRepository jobRepository,
            JobApplicationRepository applicationRepository,
            StudentProfileRepository profileRepository) {

        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.profileRepository = profileRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Map<String, Long> getStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalUsers", userRepository.count());
        stats.put("totalProfiles", profileRepository.count());
        stats.put("totalJobs", jobRepository.count());
        stats.put("totalApplications", applicationRepository.count());

        return stats;
    }
}