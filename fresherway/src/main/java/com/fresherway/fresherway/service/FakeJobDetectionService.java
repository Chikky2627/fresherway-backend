package com.fresherway.fresherway.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.entity.Job;

@Service
public class FakeJobDetectionService {

    public List<String> detectFakeJob(Job job) {

        List<String> reasons = new ArrayList<>();

        // Rule 1: Company Name
        if (job.getCompanyName() == null ||
                job.getCompanyName().trim().isEmpty()) {

            reasons.add("Company name is missing.");
        }

        // Rule 2: Job Title
        if (job.getJobTitle() == null ||
                job.getJobTitle().trim().isEmpty()) {

            reasons.add("Job title is missing.");
        }

        // Rule 3: Salary Check
        if (job.getSalary() != null &&
                job.getSalary() > 3000000) {

            reasons.add("Unrealistic salary for fresher.");
        }

        // Rule 4: Description Keywords
        if (job.getDescription() != null) {

            String description =
                    job.getDescription().toLowerCase();

            if (description.contains("registration fee")) {

                reasons.add("Contains 'Registration Fee'.");
            }

            if (description.contains("pay fee")) {

                reasons.add("Contains 'Pay Fee'.");
            }

            if (description.contains("investment")) {

                reasons.add("Contains 'Investment'.");
            }

            if (description.contains("earn money fast")) {

                reasons.add("Contains suspicious keyword.");
            }

            if (description.contains("whatsapp")) {

                reasons.add("Only WhatsApp contact found.");
            }

            if (description.contains("telegram")) {

                reasons.add("Telegram recruitment detected.");
            }

        }

        // Rule 5: Skills Missing
        if (job.getSkillsRequired() == null ||
                job.getSkillsRequired().trim().isEmpty()) {

            reasons.add("Skills are not mentioned.");
        }

        return reasons;
    }

    public void processJob(Job job) {

        List<String> reasons =
                detectFakeJob(job);

        if (reasons.isEmpty()) {

            job.setFakeJob(false);
            job.setFakeReason("");

        } else {

            job.setFakeJob(true);

            job.setFakeReason(
                    String.join(", ", reasons));
        }

        job.setActive(true);

        job.setPostedDate(LocalDate.now());

       job.setExpiryDate(LocalDate.now().plusWeeks(2));
    }

}