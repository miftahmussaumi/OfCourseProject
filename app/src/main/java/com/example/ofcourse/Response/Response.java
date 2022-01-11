package com.example.ofcourse.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("Response")
	private List<Result> results;

	public void setResults(List<Result> results){
		this.results = results;
	}

	public List<Result> getResults(){
		return results;
	}
}