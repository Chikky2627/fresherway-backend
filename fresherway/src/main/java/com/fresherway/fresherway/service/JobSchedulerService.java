package com.fresherway.fresherway.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.repository.JobRepository;

@Service
public class JobSchedulerService {

    private final JobRepository jobRepository;

    public JobSchedulerService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Runs every day at 1:00 AM
   @Scheduled(cron = "0 * * * * *")
public void removeExpiredJobs() {

    System.out.println("Checking expired jobs...");

    List<Job> jobs = jobRepository.findAll();

    for (Job job : jobs) {

        if (Boolean.TRUE.equals(job.getActive())
                && job.getExpiryDate() != null
                && job.getExpiryDate().isBefore(LocalDate.now())) {

            job.setActive(false);

            jobRepository.save(job);

            System.out.println("Expired Job: " + job.getJobTitle());
        }
    }
}
}