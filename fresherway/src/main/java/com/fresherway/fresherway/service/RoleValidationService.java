package com.fresherway.fresherway.service;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.entity.User;

@Service
public class RoleValidationService {

    public boolean isAdmin(User user) {
        return "ADMIN".equals(user.getRole());
    }

    public boolean isCompany(User user) {
        return "COMPANY".equals(user.getRole());
    }

    public boolean isStudent(User user) {
        return "STUDENT".equals(user.getRole());
    }
}