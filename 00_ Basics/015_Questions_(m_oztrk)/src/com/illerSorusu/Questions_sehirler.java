package com.illerSorusu;

import java.util.Scanner;

public class Questions_sehirler {	
	 
	public static void main(String[] args) {
		
// Soru 1) Dışarıdan girilen harfle başlayan illeri yazdıran metodu yazın.
		
		İller cities = new İller();		
				
//		ileBaslayanlariYazdir(cities.iller);
		
// Soru 2) İlleri plaka kodları ile yazdıran metodu yazınız. 01-Adana, 02-Adıyaman...
		
//		plakaKodlariylaYazdir(cities.iller);
		
// Soru 3) Girdiğimiz şehrin ismine göre plaka dönen metodu yazınız.		
		
//		System.out.println(plakasiniGetir(cities.iller));
		
// Soru 3.5) 3. soruyu Varargs ile çözünüz.
		
//		String[] sonucPlakalar = plakasiniGetirVarargs(cities.iller, "ankara", "elazığ", "muğla", "konya", "düzce");
//		for(int i=0; i<sonucPlakalar.length; i++) {
//			System.out.print(sonucPlakalar[i] + ", ");
//		}
		
// Soru 4) Şehirlerin ilk harf hariç sesli harflerini silip o şekilde
// yazdıran metodu yazınız.
		
//		for(int i=0; i<sesliHarfleriSil(cities.iller).length; i++) {
//			System.out.println(sesliHarfleriSil(cities.iller)[i]);
//		}
		
		
// Soru 5) Bir önceki metottan dönen değerlerin ilk üç harfini alın ve
//		sonuna ... ekleyin. (Metodu yazın). Adn...  Ady... gibi
		
//		ilkUcHarfVeUcNokta(sesliHarfleriSil(cities.iller));
		
// Soru 6) Bir önceki metottan dönen dizide B ile başlayan illerin başına
//			1-Blk gibi yazdıralım.
		
// Soru 7) İkinci harfi 'a' olanların ilk değeri ve sadece ilk 3 harfini
//			büyük yazdırın. Çankırı -> ÇAN		
		
		ikinciHarfiAOlanlarinIlkUcHarfiniYazdir(cities.iller);
		
	}//main ends here
	
	public static void ileBaslayanlariYazdir(String[] strArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Hangi harfle başlayan illerin listesini istiyorsunuz?: ");
		String harf = sc.nextLine().toUpperCase().substring(0,1);
		for(int i=0; i<strArray.length; i++) {
			if(strArray[i].startsWith(harf)) {
				System.out.print(strArray[i] + ", ");
			}
		}		
	}
	
	public static void plakaKodlariylaYazdir(String[] strArray) {		
		for(int i=0; i<strArray.length;i++) {			
			if(i+1<10) {
				System.out.println("0" + (i+1) + "-" + strArray[i] + ", ");				
			}else {
				System.out.println((i+1) + "-" + strArray[i] + ", ");
			}
			
			
		}
	}
	
	public static String plakasiniGetir(String[] illerDizisi) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Plakasını görmek istediğiniz şehri yazınız: ");
		String sehir = sc.nextLine();
		for(int i=0; i<illerDizisi.length; i++) {
			if(illerDizisi[i].equalsIgnoreCase(sehir)) {				
				if(i+1<10) {
					return "0" + (i+1);					
				}else {
					return (i+1) + "";					
				}
			}
		}
		return "Böyle bir il bulunamadı.";
	}
	
	public static String[] plakasiniGetirVarargs(String[] strArray, String ...sehirler) {
		String[] resultArr = new String[sehirler.length];
		int indexResultArr = 0;
		for(int i=0; i<strArray.length; i++) {
			for(int j=0; j<sehirler.length; j++) {
				if(strArray[i].equalsIgnoreCase(sehirler[j])) {				
					if(i+1<10) {
						resultArr[indexResultArr] = "0" + (i+1);
						indexResultArr++;
					}else {
						resultArr[indexResultArr] = (i+1) + "";
						indexResultArr++;
					}
				}
			}
		}
		return resultArr;
	}
	
	public static String[] sesliHarfleriSil(String[] strArr) {
		String[] resultArr = new String[strArr.length];
		for(int i=0; i<strArr.length; i++) {
			String firstLetter = strArr[i].substring(0,1);
			String afterFirstLetter = strArr[i].substring(1);			
			afterFirstLetter = afterFirstLetter.replace("a", "")
											   .replace("e", "")
											   .replace("ı", "")
											   .replace("i", "")
											   .replace("o", "")
											   .replace("ö", "")
											   .replace("u", "")
											   .replace("ü", "");			
			resultArr[i] = firstLetter + afterFirstLetter;
		}
		return resultArr;
	}
	
	public static void ilkUcHarfVeUcNokta(String[] strArray) {
		for(int i=0; i<strArray.length; i++) {
			if(strArray[i].length() >= 3) {
				System.out.println(strArray[i].substring(0,3) + "...");
			}else if(strArray[i].length() >= 1 && strArray[i].length() <= 2) {
				System.out.println(strArray[i] + "...");
			}
			
		}
	}
	
	public static void ikinciHarfiAOlanlarinIlkUcHarfiniYazdir(String[] strArray) {
		for(int i=0; i<strArray.length; i++) {
			if(strArray[i].charAt(1) == 'a') {
				System.out.println(strArray[i].substring(0,3).toUpperCase());
			}
		}
	}
	
}//class ends here
