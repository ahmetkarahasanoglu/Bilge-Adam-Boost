package com.package2;

public class Question39 {

	public static void main(String[] args) {
		
	/*
	 * Soru: String değişken olarak verilen şehirleri bir diziye
	 * atayalım. Daha sonra her bir şehir için çıktı alalım.
	 * "Adana'nın plaka kodu 01" gibi.
	 */
		String sehirler = "01-Adana;02-Adıyaman;03-Afyonkarahisar;"
				+ "04-Ağrı;05-Amasya;06-Ankara;07-Antalya;08-Artvin;"
				+ "09-Aydın;10-Balıkesir;42-Konya";
		
		String[] sehirlerArr = sehirler.split(";");
		
		for(int i=0; i<sehirlerArr.length; i++) {
			String plakaKodu = sehirlerArr[i].substring(0,2);
			String sehir = sehirlerArr[i].substring(sehirlerArr[i].indexOf("-")+1);
			System.out.println(sehir + " şehrinin plaka kodu: " + plakaKodu);
		}
		
		
	}
}
