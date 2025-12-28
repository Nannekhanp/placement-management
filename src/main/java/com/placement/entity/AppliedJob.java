package com.placement.entity;

import javax.persistence.*;

@Entity
@Table(name = "applied_jobs")
public class AppliedJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

	@Override
	public String toString() {
		return "AppliedJob [id=" + id + ", studentId=" + studentId + ", job=" + job + "]";
	}
    
    
}
