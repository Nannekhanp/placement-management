package com.placement.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.placement.entity.Student;
import com.placement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final String uploadDir = "E://applications//resumes//"; // change as needed

    /**
     * Register a new student with personal, education details + resume
     */
    public Student register(Student student, MultipartFile resume) throws IOException {
        // Check duplicate email
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Upload resume
        if (resume != null && !resume.isEmpty()) {
            File folder = new File(uploadDir);
            if (!folder.exists()) folder.mkdirs();

            String path = uploadDir + System.currentTimeMillis() + "_" + resume.getOriginalFilename();
            resume.transferTo(new File(path));
            student.setResumePath(path);
        }

        // Set default values
        student.setPlaced(false);

        return studentRepository.save(student);
    }

    /**
     * Student login
     */
    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        if (student == null) throw new RuntimeException("Invalid email");

        if (!student.getPassword().trim().equals(password.trim()))
            throw new RuntimeException("Invalid password");

        return student;
    }

    /**
     * Get all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
