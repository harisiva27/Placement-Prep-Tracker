package com.placementtracker.service.impl;

import com.placementtracker.entity.CodingProblem;
import com.placementtracker.repository.CodingProblemRepository;
import com.placementtracker.service.CodingProblemService;
import org.springframework.stereotype.Service;

@Service
public class CodingProblemServiceImpl implements CodingProblemService {

    private final CodingProblemRepository codingProblemRepository;

    public CodingProblemServiceImpl(CodingProblemRepository codingProblemRepository) {
        this.codingProblemRepository = codingProblemRepository;
    }

    // TODO: Implement CRUD methods
}
