package com.placement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.entity.Company;
import com.placement.repository.CompanyRepository;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/register")
    public Company register(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Company company) {

        Company existingCompany = companyRepository
            .findByEmailAndPassword(company.getEmail(), company.getPassword());

        if (existingCompany == null) {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid email or password");
        }

        return ResponseEntity.ok(existingCompany);
    }
}
