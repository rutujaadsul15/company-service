package com.company.service;

import com.company.entity.Company;
import com.company.repository.CompanyRepository;
import com.company.request.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setCompanySector(companyRequest.getCompanySector());

        companyRepository.save(company);
    }

    @Override
    public Company getCompany(String companyName) {
       return companyRepository.findAll()
                .stream()
                .filter(company ->
                        company.getCompanyName()
                                .equals(companyName))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Company updateCompnay(Map<String,Object> patchData, Integer id) {
        Company company = companyRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if(patchData.containsKey("companyName")){
            company.setCompanyName((String)patchData.get("companyName"));
        }
        if(patchData.containsKey("companySector")){
            company.setCompanySector((String)patchData.get("companySector"));
        }
        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(Integer id) {
        Optional<Company> byId = companyRepository.findById(id);
       return byId.orElse(null);

    }
}
