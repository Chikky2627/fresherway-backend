package com.fresherway.fresherway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fresherway.fresherway.entity.Job;

public interface JobRepository
        extends JpaRepository<Job, Long> {
}