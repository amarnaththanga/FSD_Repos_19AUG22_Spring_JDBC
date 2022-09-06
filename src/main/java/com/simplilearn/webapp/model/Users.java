package com.simplilearn.webapp.model;

import java.util.Date;

public class Users {
	// data properties
	private long id;
	private String username;
	private String password;
	private String email;
	private String gender;
	private Date createdAt;
	
	
	// Public Constructors
	public Users() {};
	
	public Users(long id, String username, String password, String email, String gender, Date createdAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
	}

	// Public get and set methods
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", gender=" + gender + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
}
