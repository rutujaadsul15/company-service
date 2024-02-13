package com.company.service;

import com.company.entity.Company;
import com.company.request.CompanyRequest;

public interface CompanyService {
    void saveCompany(CompanyRequest companyRequest);

    Company getCompany(Integer id);

    Company getCompany(String companyName);
}
