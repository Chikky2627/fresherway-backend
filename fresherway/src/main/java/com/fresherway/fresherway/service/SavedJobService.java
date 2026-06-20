package com.fresherway.fresherway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.SavedJobRequest;
import com.fresherway.fresherway.entity.SavedJob;
import com.fresherway.fresherway.repository.SavedJobRepository;

@Service
public class SavedJobService {

    private final SavedJobRepository savedJobRepository;

    public SavedJobService(
            SavedJobRepository savedJobRepository) {

        this.savedJobRepository = savedJobRepository;
    }

    public String saveJob(
            SavedJobRequest request) {

        SavedJob savedJob = new SavedJob();

        savedJob.setUserId(request.getUserId());
        savedJob.setJobId(request.getJobId());

        savedJobRepository.save(savedJob);

        return "Job Saved Successfully";
    }

    public List<SavedJob> getSavedJobs(
            Long userId) {

        return savedJobRepository.findByUserId(userId);
    }

    public String removeSavedJob(
            Long userId,
            Long jobId) {

        savedJobRepository
                .deleteByUserIdAndJobId(
                        userId,
                        jobId);

        return "Saved Job Removed";
    }
}