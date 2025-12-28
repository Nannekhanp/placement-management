package com.placement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.placement.entity.Student;
import com.placement.repository.StudentRepository;
import com.placement.service.StudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000") // Adjust if frontend hosted elsewhere
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Register student with personal, education details + resume
	 */
	@PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> register(@RequestPart("student") Student student,
			@RequestPart("resume") MultipartFile resume) {

		try {
			Student saved = studentService.register(student, resume);
			return ResponseEntity.ok(saved);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
		}
	}

	/**
	 * Login student
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Student student) {
		try {
			Student s = studentService.login(student.getEmail(), student.getPassword());
			return ResponseEntity.ok(s);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id) {
	    try {
	        return ResponseEntity.ok(studentService.getStudentById(id));
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
}
