package com.placementtracker.service.impl;

import com.placementtracker.entity.MockInterview;
import com.placementtracker.repository.MockInterviewRepository;
import com.placementtracker.service.MockInterviewService;
import org.springframework.stereotype.Service;

@Service
public class MockInterviewServiceImpl implements MockInterviewService {

    private final MockInterviewRepository mockInterviewRepository;

    public MockInterviewServiceImpl(MockInterviewRepository mockInterviewRepository) {
        this.mockInterviewRepository = mockInterviewRepository;
    }

    // TODO: Implement CRUD methods
}
