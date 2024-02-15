package com.company.controller;

import com.company.entity.Company;
import com.company.request.CompanyRequest;
import com.company.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping("/saveCompany")
    public void saveCompany(@RequestBody CompanyRequest companyRequest) {
        companyService.saveCompany(companyRequest);
    }

    @GetMapping("/getCompany/{companyName}")
    public Company getCompanyByPathVariable(@PathVariable String companyName) {
        return companyService.getCompany(companyName);
    }

    @GetMapping("/getCompany")
    public Company getCompanyByRequestParam(@RequestParam("id") Integer id) {
        return companyService.getCompany(id);
    }

    @PatchMapping("/updateCompnay/{id}")
    public ResponseEntity<?> updateCompnay(@RequestBody Map<String, Object> patchData, @PathVariable Integer id) {
        Company updateCompnay = companyService.updateCompnay(patchData, id);
        return ResponseEntity.ok(updateCompnay);

    }

}
