package com.placement.service;

import com.placement.entity.Admin;
import com.placement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public Admin saveAdmin(Admin admin) {
        return repo.save(admin);
    }

    public boolean emailExists(String email) {
        return repo.existsByEmail(email);
    }
}