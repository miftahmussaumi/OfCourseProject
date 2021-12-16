package com.example.ofcourse.Model.login;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private LoginData loginData;

	@SerializedName("status")
	private boolean status;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(LoginData loginData){
		this.loginData = loginData;
	}

	public LoginData getUser(){
		return loginData;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public LoginData getLoginData() {
		return loginData;
	}
}