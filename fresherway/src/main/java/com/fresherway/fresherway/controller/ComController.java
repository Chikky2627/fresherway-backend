package com.fresherway.fresherway.controller;

import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.CompanyRequest;
import com.fresherway.fresherway.entity.Company;
import com.fresherway.fresherway.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class ComController {

    private final CompanyService companyService;

    public ComController(
            CompanyService companyService) {

        this.companyService = companyService;
    }

    @PostMapping
    public String createCompany(
            @RequestBody CompanyRequest request) {

        return companyService
                .createCompany(request);
    }

    @GetMapping("/{userId}")
    public Company getCompany(
            @PathVariable Long userId) {

        return companyService
                .getCompany(userId);
    }
}