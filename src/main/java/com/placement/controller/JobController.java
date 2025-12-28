package com.placement.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/apply")
    public void applyJob(@RequestParam Long studentId, @RequestParam Long jobId) {
        jobService.applyJob(studentId, jobId);
    }

    @GetMapping("/applied/{studentId}")
    public List<AppliedJob> appliedJobs(@PathVariable Long studentId) {
        return jobService.getAppliedJobs(studentId);
    }
}
