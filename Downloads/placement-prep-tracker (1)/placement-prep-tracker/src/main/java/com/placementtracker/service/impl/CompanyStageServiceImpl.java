package com.placementtracker.service.impl;

import com.placementtracker.entity.CompanyStage;
import com.placementtracker.repository.CompanyStageRepository;
import com.placementtracker.service.CompanyStageService;
import org.springframework.stereotype.Service;

@Service
public class CompanyStageServiceImpl implements CompanyStageService {

    private final CompanyStageRepository companyStageRepository;

    public CompanyStageServiceImpl(CompanyStageRepository companyStageRepository) {
        this.companyStageRepository = companyStageRepository;
    }

    // TODO: Implement CRUD methods
}
