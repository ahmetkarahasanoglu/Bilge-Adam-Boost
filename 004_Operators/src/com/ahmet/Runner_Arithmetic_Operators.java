package com.ahmet;

public class Runner_Arithmetic_Operators {

	public static void main(String[] args) {
		// If today is Friday; what day is it after 24 days?
		int elapsedDay = 24;
		int startingDay = 5;
		int result = (startingDay + elapsedDay) % 7;
		System.out.println(result); // 1 --> Monday
	}
}
