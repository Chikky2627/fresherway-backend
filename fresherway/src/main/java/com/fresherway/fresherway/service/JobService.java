package com.fresherway.fresherway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.JobRequest;
import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public String createJob(JobRequest request) {

        Job job = new Job();

        job.setCompanyName(request.getCompanyName());
        job.setJobTitle(request.getJobTitle());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setSkillsRequired(request.getSkillsRequired());
        job.setDescription(request.getDescription());

        jobRepository.save(job);

        return "Job Posted Successfully";
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public List<Job> searchBySkill(String skill) {
    return jobRepository
            .findBySkillsRequiredContaining(skill);
}

public List<Job> searchByLocation(String location) {
    return jobRepository
            .findByLocationContaining(location);
}

public List<Job> searchByCompany(String company) {
    return jobRepository
            .findByCompanyNameContaining(company);
}
public List<Job> searchBySkillAndLocation(
        String skill,
        String location) {

    return jobRepository
            .findBySkillsRequiredContainingAndLocationContaining(
                    skill,
                    location);
}
}