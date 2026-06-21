package com.fresherway.fresherway.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.entity.Job;
import com.fresherway.fresherway.entity.JobApplication;
import com.fresherway.fresherway.entity.User;
import com.fresherway.fresherway.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return adminService.getAllJobs();
    }

    @GetMapping("/applications")
    public List<JobApplication> getAllApplications() {
        return adminService.getAllApplications();
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        return adminService.getStats();
    }
    @GetMapping("/hello")
public String adminTest() {
    return "Admin Access Success";
}
}