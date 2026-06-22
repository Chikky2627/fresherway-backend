package com.fresherway.fresherway.service;

import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.CompanyRequest;
import com.fresherway.fresherway.entity.Company;
import com.fresherway.fresherway.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(
            CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    public String createCompany(
            CompanyRequest request) {

        Company company = new Company();

        company.setUserId(request.getUserId());
        company.setCompanyName(
                request.getCompanyName());
        company.setWebsite(
                request.getWebsite());
        company.setLocation(
                request.getLocation());
        company.setDescription(
                request.getDescription());

        companyRepository.save(company);

        return "Company Created Successfully";
    }

    public Company getCompany(
            Long userId) {

        return companyRepository
                .findByUserId(userId)
                .orElse(null);
    }
}