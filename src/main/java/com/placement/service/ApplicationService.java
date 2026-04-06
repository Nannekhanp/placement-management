package com.placement.service;

import com.placement.entity.Application;
import com.placement.entity.Job;
import com.placement.entity.Student;
import com.placement.repository.ApplicationRepository;
import com.placement.repository.JobRepository;
import com.placement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobRepository jobRepository;

    // Get all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Update status
    public Application updateStatus(Long id, String status) {
        Application app = applicationRepository.findById(id).orElse(null);
        if (app == null) return null;

        app.setStatus(status);
        return applicationRepository.save(app);
    }

    // Student applies to job
    public Application applyJob(Long studentId, Long jobId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Job job = jobRepository.findById(jobId).orElse(null);
        if (student == null || job == null) return null;

        Application app = new Application();
        app.setStudent(student);
        app.setJob(job);
        app.setStatus("PENDING");
        return applicationRepository.save(app);
    }
}