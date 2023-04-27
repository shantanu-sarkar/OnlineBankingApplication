package com.kpmg.entities;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class ApplicationUser implements UserDetails {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	

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
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "user_role_junction",
			joinColumns= @JoinColumn(name="user_id"),
			inverseJoinColumns= @JoinColumn(name="role_id")
			)
	private Set<Role> authorities;

	
	public ApplicationUser() {
		super();
		this.authorities = new HashSet<Role>();
	}
	
	
	public ApplicationUser(int userId, String username, String password,Set<Role> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public ApplicationUser(int userId, String username, String password, String firstName, String middleName,
			String lastName, String fatherName, long mobileNumber, String emailID, long aadharNumber, Date dateOfBirth,
			Set<Role> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.mobileNumber = mobileNumber;
		this.emailID = emailID;
		this.aadharNumber = aadharNumber;
		this.dateOfBirth = dateOfBirth;
		this.authorities = authorities;
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



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
