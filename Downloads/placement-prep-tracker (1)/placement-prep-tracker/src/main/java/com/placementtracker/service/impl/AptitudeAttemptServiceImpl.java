package com.placementtracker.service.impl;

import com.placementtracker.entity.AptitudeAttempt;
import com.placementtracker.repository.AptitudeAttemptRepository;
import com.placementtracker.service.AptitudeAttemptService;
import org.springframework.stereotype.Service;

@Service
public class AptitudeAttemptServiceImpl implements AptitudeAttemptService {

    private final AptitudeAttemptRepository aptitudeAttemptRepository;

    public AptitudeAttemptServiceImpl(AptitudeAttemptRepository aptitudeAttemptRepository) {
        this.aptitudeAttemptRepository = aptitudeAttemptRepository;
    }

    // TODO: Implement CRUD methods
}
