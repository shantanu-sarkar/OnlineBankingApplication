package com.kpmg.entities;

import java.sql.Date;

import jakarta.persistence.Column;

public class RegistrationDTO {

	@Column(name = "First Name")
	private String firstName;

	@Column(name = "Middle Name")
	private String middleName;

	@Column(name = "Last Name")
	private String lastName;

	@Column(name = "Father's Name")
	private String fatherName;

	@Column(name = "Mobile Number")
	private long mobileNumber;

	@Column(name = "Email")
	private String emailID;

	@Column(name = "AadharNumber")
	private long aadharNumber;

	@Column(name = "Date of Birth")
	private Date dateOfBirth;

	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;


	public RegistrationDTO() {

	}


	public RegistrationDTO(String firstName, String middleName, String lastName, String fatherName, long mobileNumber,
			String emailID, long aadharNumber, Date dateOfBirth, String username, String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.mobileNumber = mobileNumber;
		this.emailID = emailID;
		this.aadharNumber = aadharNumber;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public long getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "RegistrationDTO [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", mobileNumber=" + mobileNumber + ", emailID=" + emailID
				+ ", aadharNumber=" + aadharNumber + ", dateOfBirth=" + dateOfBirth + ", username=" + username
				+ ", password=" + password + "]";
	}

	
	
	}
