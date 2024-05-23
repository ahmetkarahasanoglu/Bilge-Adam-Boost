package com.ahmet.entity;

public class En implements IDil {

	@Override
	public String getHello() {
		return "WELCOME";
	}

	@Override
	public String getLogin1() {		
		return "Sign Up";
	}

	@Override
	public String getLogin2() {
		return "Login";
	}

	@Override
	public String getLogin3() {
		return "Guest";
	}

	@Override
	public String getLogin4() {
		return "Introduction";
	}

	@Override
	public String getStop() {
		return "PROGRAM ENDED";
	}
	
	

}
