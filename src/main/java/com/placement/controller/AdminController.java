package com.placement.controller;

import com.placement.entity.Admin;
import com.placement.repository.AdminRepository;
import com.placement.service.AdminService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService service;
    
    @Autowired
    private AdminRepository repo;

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Admin admin) {

        if (service.emailExists(admin.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        service.saveAdmin(admin);

        return ResponseEntity.ok("Admin Registered Successfully");
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {

        Admin existingAdmin = repo.findByEmail(admin.getEmail());

        if (existingAdmin == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "User not found");

            return ResponseEntity.status(401).body(response);
        }

        if (!existingAdmin.getPassword().equals(admin.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Invalid password");

            return ResponseEntity.status(401).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("admin", existingAdmin);

        return ResponseEntity.ok(response);
    }
    
}