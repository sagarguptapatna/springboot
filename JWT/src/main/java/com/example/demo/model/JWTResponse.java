package com.example.demo.model;

public class JWTResponse {

	String tocken;
	
	public JWTResponse() {
		
	}
public JWTResponse(String tocken) {
	this.tocken=tocken;
		
	}
public String getTocken() {
	return tocken;
}
public void setTocken(String tocken) {
	this.tocken = tocken;
}

	
}
