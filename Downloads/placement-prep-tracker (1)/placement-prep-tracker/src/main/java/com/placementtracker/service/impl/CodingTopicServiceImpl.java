package com.placementtracker.service.impl;

import com.placementtracker.entity.CodingTopic;
import com.placementtracker.repository.CodingTopicRepository;
import com.placementtracker.service.CodingTopicService;
import org.springframework.stereotype.Service;

@Service
public class CodingTopicServiceImpl implements CodingTopicService {

    private final CodingTopicRepository codingTopicRepository;

    public CodingTopicServiceImpl(CodingTopicRepository codingTopicRepository) {
        this.codingTopicRepository = codingTopicRepository;
    }

    // TODO: Implement CRUD methods
}
