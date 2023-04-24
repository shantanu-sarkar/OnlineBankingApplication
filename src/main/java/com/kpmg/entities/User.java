package com.kpmg.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;

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

@Column(name="User_Password")
private String password;

public User(String password) {
	this.password = password;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


@PrimaryKeyJoinColumn(name = "Account")
@OneToOne
private Account account;


public User() {
}


public int getUserId() {
	return userId;
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


public Account getAccount() {
	return account;
}


public void setAccount(Account account) {
	this.account = account;
}


public User(String firstName, String middleName, String lastName, String fatherName, long mobileNumber,
		String emailID, long aadharNumber, Date dateOfBirth, Account account) {
	
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.fatherName = fatherName;
	this.mobileNumber = mobileNumber;
	this.emailID = emailID;
	this.aadharNumber = aadharNumber;
	this.dateOfBirth = dateOfBirth;
	this.account = account;
}




}
