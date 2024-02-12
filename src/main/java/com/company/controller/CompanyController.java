package com.company.controller;

import com.company.entity.Company;
import com.company.request.CompanyRequest;
import com.company.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;
        @PostMapping("/saveCompany")
    public void saveCompany(@RequestBody CompanyRequest companyRequest){
     companyService.saveCompany(companyRequest);
    }

    @GetMapping("/getCompany/{id}")
    public Company getCompanyByPathVariable(@PathVariable Integer id){
          return companyService.getCompany(id);
    }

    @GetMapping("/getCompany")
    public Company getCompanyByRequestParam(@RequestParam("id") Integer id){
            return  companyService.getCompany(id);
    }

}
