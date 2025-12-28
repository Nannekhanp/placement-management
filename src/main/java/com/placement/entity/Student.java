package com.placement.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    // Personal Details
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String mobile;
    private String gender;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String district;
    private String pincode;

    // Education Details
    private String tenthSchool;
    private double tenthPercentage;
    private String interCollege;
    private double interPercentage;
    private String degreeUniversity;
    private String degreeCollege;
    
    private double degreePercentage;
    
    
    // Others
    private boolean placed;
    private String resumePath;
    
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getTenthSchool() {
		return tenthSchool;
	}
	public void setTenthSchool(String tenthSchool) {
		this.tenthSchool = tenthSchool;
	}
	public double getTenthPercentage() {
		return tenthPercentage;
	}
	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}
	public String getInterCollege() {
		return interCollege;
	}
	public void setInterCollege(String interCollege) {
		this.interCollege = interCollege;
	}
	public double getInterPercentage() {
		return interPercentage;
	}
	public void setInterPercentage(double interPercentage) {
		this.interPercentage = interPercentage;
	}
	public String getDegreeUniversity() {
		return degreeUniversity;
	}
	public void setDegreeUniversity(String degreeUniversity) {
		this.degreeUniversity = degreeUniversity;
	}
	public String getDegreeCollege() {
		return degreeCollege;
	}
	public void setDegreeCollege(String degreeCollege) {
		this.degreeCollege = degreeCollege;
	}
	public double getDegreePercentage() {
		return degreePercentage;
	}
	public void setDegreePercentage(double degreePercentage) {
		this.degreePercentage = degreePercentage;
	}
	public boolean isPlaced() {
		return placed;
	}
	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + ", gender=" + gender + ", dob=" + dob
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", district=" + district
				+ ", pincode=" + pincode + ", tenthSchool=" + tenthSchool + ", tenthPercentage=" + tenthPercentage
				+ ", interCollege=" + interCollege + ", interPercentage=" + interPercentage + ", degreeUniversity="
				+ degreeUniversity + ", degreeCollege=" + degreeCollege + ", degreePercentage=" + degreePercentage
				+ ", placed=" + placed + ", resumePath=" + resumePath + "]";
	}

   
}
