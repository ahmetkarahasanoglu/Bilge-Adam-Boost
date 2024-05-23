package pckge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateOrnek {
	
	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.now();
		System.out.println(date1); // 2024.01.26		
		Date date = new Date();
		System.out.println("date..................: " + date); // Fri Jan 26 19:15:41 TRT 2024
		
		LocalDateTime date2 = LocalDateTime.now();
		System.out.println("date2.................: " + date2); // 2024-01-26T19:13:31.814027200
		
		System.out.println("date2.plusDays(25)....: " + date2.plusDays(25));
		System.out.println("date2.plusMonths(1)...: " + date2.plusMonths(1));
		System.out.println("date2.plusWeeks(2)....: " + date2.plusWeeks(2));
		System.out.println("date2.plusYears(1)....: " + date2.plusYears(1));
		
		System.out.println("date2.minusDays(5)....: " + date2.minusDays(5));		
		
	}//MAIN ENDS HERE -------
	
}//CLASS ENDS HERE ------
