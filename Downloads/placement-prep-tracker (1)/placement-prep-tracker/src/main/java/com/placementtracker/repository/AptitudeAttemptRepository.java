package com.placementtracker.repository;

import com.placementtracker.entity.AptitudeAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudeAttemptRepository extends JpaRepository<AptitudeAttempt, Long> {
}
