package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmail(String email);
    
    Admin findByEmail(String email);
}