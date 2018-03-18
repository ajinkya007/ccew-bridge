package com.citib.arbitrage.model;

public class Login {
	private String username;
	private String password;
	
	public Login(){}
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	// username
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
	// password
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
}
