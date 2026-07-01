package com.fresherway.fresherway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.JobRequest;
import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.exception.ResourceNotFoundException;
import com.fresherway.fresherway.repository.JobRepository;


@Service
public class JobService {

    private final JobRepository jobRepository;
    private final FakeJobDetectionService fakeJobDetectionService;

    public JobService(JobRepository jobRepository, FakeJobDetectionService fakeJobDetectionService) {
        this.jobRepository = jobRepository;
        this.fakeJobDetectionService = fakeJobDetectionService;
    }

    public String createJob(JobRequest request) {

        Job job = new Job();

        job.setCompanyName(request.getCompanyName());
        job.setJobTitle(request.getJobTitle());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setSkillsRequired(request.getSkillsRequired());
        job.setDescription(request.getDescription());
        fakeJobDetectionService.processJob(job);

jobRepository.save(job);

if (Boolean.TRUE.equals(job.getFakeJob())) {

    return "Fake Job Detected!\nReason: " + job.getFakeReason();

}
       

        return "Job Posted Successfully";
    }

    public List<Job> getAllJobs() {
        return jobRepository.findByActiveTrueAndFakeJobFalse();

    }
    public List<Job> getFakeJobs() {

    return jobRepository.findByFakeJobTrue();

}

   public Job getJobById(Long id) {

    return jobRepository
            .findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Job Not Found With Id: " + id));
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
public String deleteJob(Long id){

    jobRepository.deleteById(id);

    return "Job Deleted Successfully";

}
}