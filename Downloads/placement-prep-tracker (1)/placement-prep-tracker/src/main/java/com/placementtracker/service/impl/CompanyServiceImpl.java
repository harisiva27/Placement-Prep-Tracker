package com.placementtracker.service.impl;

import com.placementtracker.entity.Company;
import com.placementtracker.repository.CompanyRepository;
import com.placementtracker.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // TODO: Implement CRUD methods
}
