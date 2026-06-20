package com.fresherway.fresherway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.fresherway.fresherway.entity.SavedJob;

public interface SavedJobRepository
        extends JpaRepository<SavedJob, Long> {

    List<SavedJob> findByUserId(Long userId);

    @Modifying
    @Transactional
    void deleteByUserIdAndJobId(
            Long userId,
            Long jobId);
}