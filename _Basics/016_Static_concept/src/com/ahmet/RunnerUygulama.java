package com.ahmet;

public class RunnerUygulama {

	public static void main(String[] args) {
		
		StaticValues sv = new StaticValues(); 
		System.out.println(sv.owner); // '--> creating an object consumes RAM.
		
		System.out.println(StaticValues.owner); // accessing through class (static field)

	}//main ends here

}//class ends here
