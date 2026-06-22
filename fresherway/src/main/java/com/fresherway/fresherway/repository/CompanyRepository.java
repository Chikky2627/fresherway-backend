package com.fresherway.fresherway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresherway.fresherway.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
     Optional<Company> findByUserId(Long userId);
}
