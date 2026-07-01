package com.fresherway.fresherway.controller;

import org.springframework.http.ResponseEntity;
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
public ResponseEntity<StudentProfile> getProfile(
        @PathVariable Long userId) {

    StudentProfile profile = profileService.getProfile(userId);

    if (profile == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(profile);
}
    

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateProfile(
            @PathVariable Long userId,
            @RequestBody ProfileRequest request) {

        String result = profileService.updateProfile(userId, request);
        return ResponseEntity.ok(result);
    }
}