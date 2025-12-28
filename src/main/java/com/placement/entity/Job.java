package com.placement.entity;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String title;
    private String company;
    private String location;
    private String description;
    private double minCgpa;
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMinCgpa() {
		return minCgpa;
	}
	public void setMinCgpa(double minCgpa) {
		this.minCgpa = minCgpa;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", company=" + company + ", location=" + location
				+ ", description=" + description + ", minCgpa=" + minCgpa + "]";
	}

    
}
