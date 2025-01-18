package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private String username;
	private String userpwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
