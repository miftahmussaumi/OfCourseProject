package com.example.ofcourse.Model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private RegisterData registerData;

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

	public void setUser(RegisterData registerData){
		this.registerData = registerData;
	}

	public RegisterData getUser(){
		return registerData;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}