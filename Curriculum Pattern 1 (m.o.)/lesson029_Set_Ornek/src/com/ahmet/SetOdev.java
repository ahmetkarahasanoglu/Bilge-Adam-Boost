package com.ahmet;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Dışarıdan bir string değer alacağız.
 * Bu string değerdeki her harfi kontrol edeceğiz; tekrar
 * edenleri bir sete, tekrar etmeyenleri başka bir sete
 * atacağız.
 * Daha sonra bu iki seti yazdıracağız.
 * 
 * araba
 * tekrar edenler: a
 * tekrar etmeyenler: r, b
 */
public class SetOdev {

	
	public static void main(String[] args) {
		
		Set<Character> tekrarEtmeyenler = new LinkedHashSet<>();
		Set<Character> tekrarEdenler = new LinkedHashSet<>();
		
		metinEkle(tekrarEtmeyenler, tekrarEdenler);
		setleriYazdir(tekrarEtmeyenler, tekrarEdenler);
	
	}//MAIN ENDS HERE ----------	

	public static void metinEkle(Set<Character> tekrarEtmeyenler, Set<Character> tekrarEdenler) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Metin giriniz: ");
		String kelime = sc.nextLine();
		kelime = kelime.toLowerCase();
		for(int i=0; i<kelime.length(); i++) {
			char c = kelime.charAt(i);
			if(!tekrarEdenler.contains(c) && !tekrarEtmeyenler.add(c)) {
				tekrarEtmeyenler.remove(c);
				tekrarEdenler.add(c);
			}
		}
		
	}
	
	public static void setleriYazdir(Set<Character> tekrarEtmeyenler, Set<Character> tekrarEdenler) {
		System.out.println("--- Tekrar Etmeyenler: ---");
		tekrarEtmeyenler.forEach(System.out::println);
		System.out.println("--- Tekrar Edenler: ---");
		tekrarEdenler.forEach(System.out::println);
	}
	
}//CLASS ENDS HERE -----------
