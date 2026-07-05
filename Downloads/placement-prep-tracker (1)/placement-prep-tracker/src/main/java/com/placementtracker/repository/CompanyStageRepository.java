package com.placementtracker.repository;

import com.placementtracker.entity.CompanyStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyStageRepository extends JpaRepository<CompanyStage, Long> {
}
