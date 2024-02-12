package com.company.controller;

import com.company.request.CompanyRequest;
import com.company.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;
        @PostMapping("/saveCompany")
    public void saveCompany(@RequestBody CompanyRequest companyRequest){
     companyService.saveCompany(companyRequest);
    }

}
