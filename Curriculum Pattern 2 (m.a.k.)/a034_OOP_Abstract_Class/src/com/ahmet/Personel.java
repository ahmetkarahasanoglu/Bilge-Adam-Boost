package com.ahmet;

// abstract: Hem interface özellikleri, hem sınıf özellikleri gösterir.

public abstract class Personel {  // abstract sınıf
	
/*
 * 'static' ve 'constructor' yapısının ayağa kalkma sırasında çalışma
 * sıralaması nedir? Yani hangi yapı ilk ayağa kalkar ve adreslenir? 
 * aşağıdaki kullanımları araştırınız.
 */
		public static int sayi=4;
		
		static { // Programı çalıştırırken, içinde bulunduğumuz sınıftan bir şeyler çalıştırıldığında, ilk olarak (nesnelerin oluşmasından da önce) statik metotlar adreslenir ve çalışırlar. Bu satırdaki şey de bir statik metotmuş gibi aynı şekilde çalışır.
			System.out.println("Burası neresi?");
		}
		public Personel() {
			System.out.println("Burası sanırım constructor");
		}
		{ // iki yukardaki 'static' bloğu çalıştıktan sonra çalışma önceliği buraya geçer.
			System.out.println("Böyle bir kullanım varmış??");
		}
		
		
	
	public String ad;
	public String id;
	public double maas;
	
	
	public void maasHesapla(String personelTipi) {
		// metodun gövdesini boş bırakabiliriz, veya doldurabiliriz de.
		if(personelTipi.equals("Mudur")) {
			maas = 120_000;
		}else {
			maas = 25_000;
		}
	}
	
	void izin(int gun) {
		
	}
	
/*
 * Metotlarda abstract:
 * 'abstract' yazdığımız metotlar zorunlu kılınan metotlardır (miras
 * alan sınıfın kullanması zorunludur). Tanımladığımız yerde (burda)
 * gövde almazlar. [Tıpkı interfacelerdeki metotlar gibidir]
 */	
	public abstract void save(); 
	public abstract Personel delete(Long id);
	
	
	
}
