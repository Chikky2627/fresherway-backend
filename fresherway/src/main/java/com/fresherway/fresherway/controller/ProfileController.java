package com.fresherway.fresherway.controller;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.ProfileRequest;
import com.fresherway.fresherway.entity.StudentProfile;
import com.fresherway.fresherway.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public String createProfile(@RequestBody ProfileRequest request) {
        return profileService.createProfile(request);
    }

    @GetMapping("/{userId}")
    public StudentProfile getProfile(@PathVariable Long userId) {
        return profileService.getProfile(userId);
    }

    @PutMapping("/{userId}")
    public String updateProfile(
            @PathVariable Long userId,
            @RequestBody ProfileRequest request) {

        return profileService.updateProfile(userId, request);
    }
}