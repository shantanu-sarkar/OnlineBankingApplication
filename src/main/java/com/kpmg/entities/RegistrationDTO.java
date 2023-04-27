package com.kpmg.entities;

public class RegistrationDTO {

	private String username;
	private String password;
	public RegistrationDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public RegistrationDTO() {
		
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [username=" + username + ", password=" + password + "]";
	}
	
	
}
