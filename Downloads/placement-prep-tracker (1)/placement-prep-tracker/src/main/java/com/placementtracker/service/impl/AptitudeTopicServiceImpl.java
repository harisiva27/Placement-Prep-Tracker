package com.placementtracker.service.impl;

import com.placementtracker.entity.AptitudeTopic;
import com.placementtracker.repository.AptitudeTopicRepository;
import com.placementtracker.service.AptitudeTopicService;
import org.springframework.stereotype.Service;

@Service
public class AptitudeTopicServiceImpl implements AptitudeTopicService {

    private final AptitudeTopicRepository aptitudeTopicRepository;

    public AptitudeTopicServiceImpl(AptitudeTopicRepository aptitudeTopicRepository) {
        this.aptitudeTopicRepository = aptitudeTopicRepository;
    }

    // TODO: Implement CRUD methods
}
