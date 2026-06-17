package com.fresherway.fresherway.service;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.ProfileRequest;
import com.fresherway.fresherway.entity.StudentProfile;
import com.fresherway.fresherway.repository.StudentProfileRepository;

@Service
public class ProfileService {

    private final StudentProfileRepository profileRepository;

    public ProfileService(StudentProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public String createProfile(ProfileRequest request) {

        StudentProfile profile = new StudentProfile();

        profile.setUserId(request.getUserId());
        profile.setCollege(request.getCollege());
        profile.setBranch(request.getBranch());
        profile.setCgpa(request.getCgpa());
        profile.setSkills(request.getSkills());
        profile.setResumeUrl(request.getResumeUrl());

        profileRepository.save(profile);

        return "Profile Created Successfully";
    }

    public StudentProfile getProfile(Long userId) {

        return profileRepository
                .findByUserId(userId)
                .orElse(null);
    }

    public String updateProfile(Long userId,
                                ProfileRequest request) {

        StudentProfile profile = profileRepository
                .findByUserId(userId)
                .orElse(null);

        if (profile == null) {
            return "Profile Not Found";
        }

        profile.setCollege(request.getCollege());
        profile.setBranch(request.getBranch());
        profile.setCgpa(request.getCgpa());
        profile.setSkills(request.getSkills());
        profile.setResumeUrl(request.getResumeUrl());

        profileRepository.save(profile);

        return "Profile Updated Successfully";
    }
}