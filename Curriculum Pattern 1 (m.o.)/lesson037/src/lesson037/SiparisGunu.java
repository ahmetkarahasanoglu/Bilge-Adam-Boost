package lesson037;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Bir alışveriş tarihimiz olsun.
 * Bir de her ayın 15'i bizim fatura kesim tarihimiz.
 * 
 * 1- Alışveriş tarihi fatura tarihinden önce mi kontrol edelim,
 * önce ise "fatura tarihinden önce" diye yazdıralım,
 * sonra ise "fatura tarihinden sonra" diye yazdıralım.
 * 2- Yeni fatura tarihi ve kalan gün sayısını yazdıralım.
 */
public class SiparisGunu {
	
	public static void main(String[] args) {
		int year = 2024;
		int month = 1;
		int day = 7;
		
		LocalDate shoppingDate = LocalDate.of(year, month, day);
		int dayOfMonthOfShopping = shoppingDate.getDayOfMonth();
		int faturaKesimGunu = 15;
		// teacher solved the below in a different way, in his code.
		if(dayOfMonthOfShopping < faturaKesimGunu) {
			System.out.println("Fatura kesim tarihinden önce.");			
			int year2 = shoppingDate.getYear();
			int month2 = shoppingDate.getMonthValue();
			int day2 = faturaKesimGunu;
			System.out.println("Yeni fatura kesim tarihi: " + LocalDate.of(year2, month2, day2));
			long differenceInDays = ChronoUnit.DAYS.between(LocalDate.of(year, month, day), LocalDate.of(year2, month2, day2));
			System.out.println("Kalan gün sayısı: " + differenceInDays);
		}else {
			System.out.println("Fatura kesim tarihinden sonra.");
			int year3 = shoppingDate.getMonthValue()==12 ? shoppingDate.getYear()+1 : shoppingDate.getYear();
			int month3 = (shoppingDate.getMonthValue() + 1) % 12;
			int day3 = faturaKesimGunu;
			System.out.println("Yeni fatura kesim tarihi: " + LocalDate.of(year3, month3, day3));
			long differenceInDays = ChronoUnit.DAYS.between(LocalDate.of(year, month, day), LocalDate.of(year3, month3, day3));
			System.out.println("Kalan gün sayısı: " + differenceInDays);
		}
		
		
	}
	
}
