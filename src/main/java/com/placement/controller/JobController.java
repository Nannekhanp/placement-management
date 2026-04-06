package com.placement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.placement.entity.Job;
import com.placement.entity.AppliedJob;
import com.placement.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/jobpost")
    public Job postJob(@RequestBody Job job) {
        return jobService.postJob(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }
    
    @PutMapping("/job/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.status(404).body("Job not found");
        }

        job.setTitle(updatedJob.getTitle());
        job.setCompany(updatedJob.getCompany());
        job.setLocation(updatedJob.getLocation());
        job.setDescription(updatedJob.getDescription());
        job.setMinCgpa(updatedJob.getMinCgpa());

        Job savedJob = jobService.updateJob(job);
        return ResponseEntity.ok(savedJob);
    }

    // Delete Job
    @DeleteMapping("/job/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }


    @PostMapping("/apply")
    public void applyJob(@RequestParam Long studentId, @RequestParam Long jobId) {
        jobService.applyJob(studentId, jobId);
    }

    @GetMapping("/applied/{studentId}")
    public List<AppliedJob> appliedJobs(@PathVariable Long studentId) {
        return jobService.getAppliedJobs(studentId);
    }
}
