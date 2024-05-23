package com.ahmet;
import java.util.Random;
import java.util.Scanner;

public class Uygulama {

	public static void main(String[] args) {
		
		TasKagitMakas tkm = new TasKagitMakas();		
		String[] dizi = tkm.tasKagitMakas;		
		uygulama(dizi);	
		

	}//main ends here

	public static void uygulama(String[] dizi) {
		Scanner scan = new Scanner(System.in);
		String kontrol;
		do {			
			kontrol = "";
			String pcSecim = rastgeleHamle(dizi);		
			String benimSecimim = secim();
			if(pcSecim.equalsIgnoreCase(benimSecimim)) {
				System.out.println("Bilgisayarın seçimi: " + pcSecim);
				System.out.println("Beraberlik");
			}else {
				System.out.println("Bilgisayarın seçimi: " + pcSecim);
				whoWins(pcSecim, benimSecimim);
			}
			System.out.println("Tekrar oynamak için 'R' giriniz. Çıkış için herhangi başka karakter giriniz.");
			kontrol = scan.nextLine();
		}while(kontrol.equalsIgnoreCase("R"));
		System.out.println("Oyundan çıkılıyor...");
		
	}
	
	public static void whoWins(String pcSecim, String benimSecimim) {
		benimSecimim = benimSecimim.toLowerCase();
		switch(benimSecimim) {				
			case "taş":				
				if(pcSecim.equalsIgnoreCase("Makas")) {
					System.out.println("Siz kazandınız.");
				}else {
					System.out.println("Bilgisayar kazandı.");
				}
				break;			
			case "kağıt":				
				if(pcSecim.equalsIgnoreCase("Taş")) {
					System.out.println("Siz kazandınız.");
				}else {
					System.out.println("Bilgisayar kazandı.");
				}
				break;			
			case "makas":
				if(pcSecim.equalsIgnoreCase("Kağıt")) {
					System.out.println("Siz kazandınız.");
				}else {
					System.out.println("Bilgisayar kazandı.");
				}
				break;
			default:
				System.out.println("Girdiğiniz hamle geçersiz.");
		}
	}

	public static String secim() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Seçiminizi giriniz:(taş,kağıt,makas): ");
		String secim = scanner.nextLine();		
		return secim;
	}
	
	public static String rastgeleHamle(String[] dizi) {
		Random random = new Random();
		int randomIndex = random.nextInt(dizi.length);
		return dizi[randomIndex];
	}
	
}//class ends here
