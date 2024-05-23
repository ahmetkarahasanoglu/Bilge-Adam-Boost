package com.ahmet;

import com.ahmet.entity.User;

public class RunnerUser {

	public static void main(String[] args) {
		
		User user = new User(1L, "Ahmet", "ahka", "1234");
		System.out.println("Username........: " + user.getName());
		System.out.println("Password........: " + user.getPassword());
		System.out.println(user.toString());
	}//main ends here

}//class ends here
