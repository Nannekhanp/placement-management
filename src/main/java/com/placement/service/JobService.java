package com.placement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.placement.entity.*;
import com.placement.repository.*;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private AppliedJobRepository appliedRepo;

    public Job postJob(Job job) {
        return jobRepo.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

   
    public void applyJob(Long studentId, Long jobId) {

        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        AppliedJob aj = new AppliedJob();
        aj.setStudentId(studentId);
        aj.setJob(job);   // ✅ IMPORTANT FIX

        appliedRepo.save(aj);
    }

    public List<AppliedJob> getAppliedJobs(Long studentId) {
        return appliedRepo.findByStudentId(studentId);
    }
}
