package com.fullbright.medlab.models;

import org.springframework.stereotype.Component;

@Component
public class UserModel {

	private int userId;
	private String username;
	private String password;
	private String userType;
	
	public UserModel(int userId, String username, String password, String userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}	
	
	public UserModel() {
		
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
