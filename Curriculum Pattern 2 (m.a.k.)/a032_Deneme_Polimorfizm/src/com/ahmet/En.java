package com.ahmet;

public class En implements IDil {

	@Override
	public String getHello() {		
		return "WELCOME";
	}

	@Override
	public String getSignUp() {		
		return "Signup";
	}

	@Override
	public String getLogin() {		
		return "Login";
	}

	@Override
	public String getGuest() {		
		return "Guest";
	}

	@Override
	public String getIntroduction() {		
		return "Introduction";
	}

	@Override
	public String getStop() {		
		return "PROGRAM ENDED";
	}

}
