package com.ahmet;

import java.util.Random;

public class Uygulama {
	
	static Kart kart = new Kart();

	public static void main(String[] args) {
		
// 1) Bir deste oluşturalım. Sadece rakamları içersin: 0....51
		Uygulama uygulama = new Uygulama();
		int[] deste = uygulama.desteyiOlustur();		
		int[] karisikDeste = uygulama.desteyiKaristir(deste);
//		uygulama.karisikDesteyiGoster(karisikDeste);
		uygulama.karisikDesteyiGoster(karisikDeste, 4);
		
		
//		for(int i=0; i<deste.length; i++) {
//			System.out.println(deste[i]);
//		}
		
/* 2) Desteyi göster metodu yazalım; daha önce oluşturduğumuz 
 * deste dizisini bu metotta da kullanacağız ve indexlerine göre
 * kupa as kupa2 ...... Maça as maça2......
 */
		
//		uygulama.siraliDesteyiGoster();
//		uygulama.karisikDesteyiGoster();
		
	}//main ends here
	
	public int[] desteyiOlustur() {// Destenin her bir elemanında sayı (0'dan - 51'e artan şekilde) olacak şekilde deste oluşturur.
		int[] deste = new int[kart.kartNumaralari.length * kart.kartTurleri.length];
		for(int i=0; i<deste.length; i++) {
			deste[i] = i;			
		}
		return deste;
	}
	
	public int[] siraliDesteyiGoster() { // Sıralı bir şekilde tüm desteyi getirir.
		int deste[] = desteyiOlustur();
		for(int i=0; i<kart.kartTurleri.length; i++) {
			for(int j=0; j<kart.kartNumaralari.length; j++) {
				System.out.println(kart.kartTurleri[i] + "-" + kart.kartNumaralari[j]); 
			}
		}
		return deste;
	}
	
	public void karisikDesteyiGoster(int[] deste) {
		for(int i=0; i<deste.length; i++) {
			int kartIndex = deste[i] / 13;
			int numaraIndex = deste[i] % 13;
			
			String kartTuru = kart.kartTurleri[kartIndex];
			String kartNumarasi = kart.kartNumaralari[numaraIndex];
			
			System.out.println(kartTuru + " " + kartNumarasi);
		}
	}
	public void karisikDesteyiGoster(int[] deste, int kartSayisi) { // method overloading
		if(kartSayisi <= 0 || kartSayisi > 52) {
			kartSayisi = 0;
			System.out.println("Kart sayısı geçerli aralıkta girilmediği için herhangi bir değer gösterilmedi.");
		}
		for(int i=0; i<kartSayisi; i++) {
			int kartIndex = deste[i] / 13;
			int numaraIndex = deste[i] % 13;
			
			String kartTuru = kart.kartTurleri[kartIndex];
			String kartNumarasi = kart.kartNumaralari[numaraIndex];
			
			System.out.println(kartTuru + " " + kartNumarasi);
		}
	}
	
	// MY CODE FOR "karisikDesteyiGoster()" METHOD:
//	public String[] karisikDesteyiGoster() {
//		String[] siraliDeste = new String[52];
//		int indexSiraliDeste = 0;		
//		for(int i=0; i<kart.kartTurleri.length; i++) {
//			for(int j=0; j<kart.kartNumaralari.length; j++) {
//				siraliDeste[indexSiraliDeste] = kart.kartTurleri[i] + "-" + kart.kartNumaralari[j];				
//				indexSiraliDeste++;
//			}
//		}
//		String[] karisikDeste = desteyiKaristir(siraliDeste);
//		for(int i=0; i<karisikDeste.length; i++) {
//			System.out.println(karisikDeste[i]);
//		}
//		return karisikDeste;
//	}
	
	public int[] desteyiKaristir(int[] deste) {
		for(int i=0; i<deste.length; i++) {
			int rastgeleIndex = rastgeleIndexUret();
			int gecici = deste[i]; // Yer değiştirme uyguluyoruz bu 3 satırda.
			deste[i] = deste[rastgeleIndex];
			deste[rastgeleIndex] = gecici;
		}
		return deste;
	}
	public String[] desteyiKaristir(String[] deste) {
		for(int i=0; i<deste.length; i++) {
			int rastgeleIndex = rastgeleIndexUret();
			String gecici = deste[i];
			deste[i] = deste[rastgeleIndex];
			deste[rastgeleIndex] = gecici;
		}
		return deste;
	}
	public int rastgeleIndexUret() {
		Random random = new Random();
		return random.nextInt(52);
	}
	
	// --- MY CODE FOR "desteyiKaristir()" METHOD: ---
//	public String[] desteyiKaristir(String[] deck) {		
//		String arrInOrder[] = deck;
//		deck = new String[52];		
//		Random random = new Random();		
//		int randomNumber;
//		for(int i=0; i<deck.length; i++) {
//			randomNumber = random.nextInt(arrInOrder.length);
//			deck[i] = arrInOrder[randomNumber];
//			System.out.println(deck[i]);
//			
//			String[] temp = new String[arrInOrder.length - 1];
//		    int tempIndex = 0;
//		    for (int k = 0; k < arrInOrder.length; k++) {
//		        if (k != randomNumber) {
//		            temp[tempIndex] = arrInOrder[k];
//		            tempIndex++;
//		        }
//		    }
//		    arrInOrder = temp;
//		}
//		return deck;
//	}

}//class ends here
