package com.placementtracker.repository;

import com.placementtracker.entity.CodingTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodingTopicRepository extends JpaRepository<CodingTopic, Long> {
}
