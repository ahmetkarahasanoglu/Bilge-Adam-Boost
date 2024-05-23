package com.ahmet;

public class String8_Split {

	public static void main(String[] args) {
		
		/* split() method: splits a string into an array of substrings
		 * 				   by the points that you specify.
		 */
		
		String daysOfTheWeek = "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday";
		
		String[] days = daysOfTheWeek.split(",");
		for(int i=0; i<7; i++) {
			System.out.println(days[i]);
		}
		
		
		
		
		
		
	}
}
