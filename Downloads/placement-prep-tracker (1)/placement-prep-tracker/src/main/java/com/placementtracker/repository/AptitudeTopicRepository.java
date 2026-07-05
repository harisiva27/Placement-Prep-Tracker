package com.placementtracker.repository;

import com.placementtracker.entity.AptitudeTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudeTopicRepository extends JpaRepository<AptitudeTopic, Long> {
}
