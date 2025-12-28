package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placement.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
