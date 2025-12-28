package com.placement.service;

public class StudentDTO {
    private Long studentId;
    private String email;

    public StudentDTO() {}

    public StudentDTO(Long studentId, String email) {
        this.studentId = studentId;
        this.email = email;
    }

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

