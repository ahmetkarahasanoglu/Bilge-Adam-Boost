package pckge;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * Dışarıdan string olarak dogum gununuzu alınız
 * 
 * daha sonra dogdugnuz gunden bugune 
 * 
 * kaç yıl kaç gun kaç hafta kaç ay yaşamıssınız onu hesaplayıp yazdırın
 * 
 * bir sonrakli dogum gunune kaç gun kaldıgını hesaplayalım 
 * 
 * 
 * 
 */
public class DogumGunu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen dogum gunu tarihini giriniz");
		LocalDate dg = LocalDate.parse(scanner.nextLine());

		LocalDate now = LocalDate.now();

		long yil = dg.until(now, ChronoUnit.YEARS);
		long ay = dg.until(now, ChronoUnit.MONTHS);
		long hafta = dg.until(now, ChronoUnit.WEEKS);
		long gun = dg.until(now, ChronoUnit.DAYS);

		System.out
				.println("Bugune kadar " + yil + " yıl " + ay + " ay " + hafta + " hafta " + gun + " gun yaşamıssınız");

		int sonrakiDogumGunu2 = (dg.getDayOfYear() - now.getDayOfYear() + 365) % 365;
		LocalDate sonrakiDogunGunu = dg.plusYears(yil + 1);
		long fark = now.until(sonrakiDogunGunu, ChronoUnit.DAYS);
		System.out.println("Bir sonraki dogum gununuze " + fark + " gunkaldı");
		System.out.println("Bir sonraki dogum gununuze " + sonrakiDogumGunu2 + " gunkaldı");
	}

}
