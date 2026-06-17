package com.fresherway.fresherway.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fresherway.fresherway.entity.StudentProfile;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfile, Long> {

    Optional<StudentProfile> findByUserId(Long userId);
}