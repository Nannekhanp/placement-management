package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
