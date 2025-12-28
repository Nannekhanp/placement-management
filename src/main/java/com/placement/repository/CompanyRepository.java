package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByEmailAndPassword(String email, String password);
}

