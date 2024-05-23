package com.calisan;
/*
 * MÜHENDİSLERİMİZ OLACAK;
 * isim
 * soyisim
 * iş unvanı
 * maaşı
 * - en az 2 constructor yazınız (isim soyisim, isim soyisim maaş)
 * 
 * - maaş zammı metodu olacak.
 * Maaş default en az 10.000 . 
 * Eğer 10.000 - 12.000 arası unvan mühendis.
 * 12.000 - 17.000 arası kıdemli mühendis.
 * 17.000'den yüksek ise uzman mühendis.
 * Maaşı 10.000'den küçük ise stajyer.
 * Maaş zammına ek olarak 250 tl bonus alacaklar.
 * 
 * 
 * OFİS ÇALIŞANLARI OLACAK.
 * isim
 * soyisim
 * iş unvanı
 * maaşı
 * 
 * En düşük çalışan maaşı 8000.
 * 8.000 - 12.000 arası çalışan.
 * 12.000'den sonrası kıdemli çalışan
 * 8.000'den az ise stajyer.
 */

public class Test {

	public static void main(String[] args) {
		
		Muhendis muhendis = new Muhendis("Ali", "Yılmaz");
		
		System.out.println(muhendis.getMaas());
		System.out.println(muhendis.getUnvan());
		System.out.println("-------------");
		
		OfisCalisani ofisCalisani = new OfisCalisani ("Veli", "Güçlü");
		System.out.println(ofisCalisani.getMaas());
		System.out.println(ofisCalisani.getUnvan());
		System.out.println("-------------");
		
		OfisCalisani ofisCalisani2 = new OfisCalisani ("Rıfkı", "Şenlik", 15000);
		System.out.println(ofisCalisani2.getMaas());
		System.out.println("-------------");
		
		InsanKaynaklari insanKaynaklari = new InsanKaynaklari("Dursun", "Topal");
		insanKaynaklari.zamYap(muhendis, 10);
		System.out.println(muhendis.getMaas());
		
	}//main ends here

}//class ends here
