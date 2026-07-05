package com.placementtracker.repository;

import com.placementtracker.entity.MockInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockInterviewRepository extends JpaRepository<MockInterview, Long> {
}
