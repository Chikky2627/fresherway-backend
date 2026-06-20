package com.fresherway.fresherway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.SavedJobRequest;
import com.fresherway.fresherway.entity.SavedJob;
import com.fresherway.fresherway.service.SavedJobService;

@RestController
@RequestMapping("/api/saved-jobs")
public class SavedJobController {

    private final SavedJobService savedJobService;

    public SavedJobController(
            SavedJobService savedJobService) {

        this.savedJobService = savedJobService;
    }

    @PostMapping
    public String saveJob(
            @RequestBody SavedJobRequest request) {

        return savedJobService.saveJob(request);
    }

    @GetMapping("/{userId}")
    public List<SavedJob> getSavedJobs(
            @PathVariable Long userId) {

        return savedJobService.getSavedJobs(userId);
    }

    @DeleteMapping
    public String removeSavedJob(
            @RequestParam Long userId,
            @RequestParam Long jobId) {

        return savedJobService.removeSavedJob(
                userId,
                jobId);
    }
}