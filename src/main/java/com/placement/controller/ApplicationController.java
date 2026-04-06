package com.placement.controller;

import com.placement.entity.Application;
import com.placement.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/app")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Get all applications (for admin)
    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // Update application status
    @PutMapping("/applications/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String status = payload.get("status"); // SELECTED / REJECTED
        Application app = applicationService.updateStatus(id, status);
        if (app == null) {
            return ResponseEntity.status(404).body("Application not found");
        }
        return ResponseEntity.ok(app);
    }

    // Student applies to a job
    @PostMapping("/student/apply/{jobId}/{studentId}")
    public ResponseEntity<?> applyJob(@PathVariable Long jobId, @PathVariable Long studentId) {
        Application app = applicationService.applyJob(studentId, jobId);
        if (app == null) {
            return ResponseEntity.status(400).body("Invalid student or job");
        }
        return ResponseEntity.ok(app);
    }
}