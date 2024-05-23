package com.okulyonetimsistemi;
/*
 * Bir okulumuz olsun.
 * Öğrenciler, öğretmenler ve memurlar olsun.
 * Memurlar: kayıt alsın, kayıt silsin, bilgilendirme yapsın ve ders kaydı onaylasın.
 * Öğrenciler: ders kaydı oluştrusun, her dersin belli bir öğrenci kapasitesi olsun.
 * Öğretmenler: ders verebilir, etüt yapabilir ve nöbetçi olabilirler.
 * Bir öğretmen en fazla 2 derse girebilir.
 * Her çalışanın sicil numarası olsun: Ö-1, M-1.
 * 
 * Sınıfları oluştur, kalıtım uygula, interface gerekiyorsa 
 * kullan.
 */
public class Runner {
		
	public static void main(String[] args) {
			// *** WE'RE USING 'TEST' CLASS TO RUN, NOW ****
		Memur memur = new Memur();
		System.out.println(memur.sicilNo);
		
		Memur memur2 = new Memur();
		System.out.println(memur2.sicilNo);
		
		Ogretmen ogretmen = new Ogretmen();
		System.out.println(ogretmen.sicilNo); 

	}

}
