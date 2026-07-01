package com.fresherway.fresherway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresherway.fresherway.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findBySkillsRequiredContaining(String skill);

    List<Job> findByLocationContaining(String location);

    List<Job> findByCompanyNameContaining(String company);

    List<Job> findBySkillsRequiredContainingAndLocationContaining(
            String skill,
            String location);

    // Students can see only active genuine jobs
    List<Job> findByActiveTrueAndFakeJobFalse();

    // Admin can see fake jobs
    List<Job> findByFakeJobTrue();

}