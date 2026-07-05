package com.placementtracker.repository;

import com.placementtracker.entity.CodingProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodingProblemRepository extends JpaRepository<CodingProblem, Long> {
}
