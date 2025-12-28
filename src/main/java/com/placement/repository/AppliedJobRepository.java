package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placement.entity.AppliedJob;
import java.util.List;

public interface AppliedJobRepository extends JpaRepository<AppliedJob, Long> {
    List<AppliedJob> findByStudentId(Long studentId);
}
