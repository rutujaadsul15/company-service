package com.company.service;

import com.company.entity.Company;
import com.company.request.CompanyRequest;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CompanyService {
    void saveCompany(CompanyRequest companyRequest);

    Company getCompany(Integer id);

    Company getCompany(String companyName);

    Company updateCompnay(Map<String,Object> patchData, Integer id);
}
