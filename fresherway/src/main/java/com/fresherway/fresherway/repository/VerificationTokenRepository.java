package com.fresherway.fresherway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresherway.fresherway.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
  Optional<VerificationToken> findByToken(String token);
}
