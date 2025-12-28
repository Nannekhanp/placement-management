package com.placement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    
    // Optional: check if email exists
    boolean existsByEmail(String email);
    
    Optional<Student> findByStudentId(Long studentId);

}

