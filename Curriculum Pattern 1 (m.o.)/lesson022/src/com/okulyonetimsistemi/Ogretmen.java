package com.okulyonetimsistemi;

import java.util.ArrayList;

public class Ogretmen extends Calisan {

	private ArrayList<Ders> dersListesi; // bu satırda new'lemeyi tercih etmiyoruz. Çünkü boş ise gereksiz yer kaplar. Aşağıda getter & setter'da 'lazy initializing' tekniğini uygulayacaz.
	private boolean nobetciMi;
	
	
	// CONSTRUCTOR 1:
	public Ogretmen(String isim, String soyisim) {
		super(isim, soyisim);		
	}
	
	// CONSTRUCTOR 2:
	public Ogretmen(String isim, String soyisim, double maas, int calismaSaati) {
		super(isim, soyisim, maas, calismaSaati);		
	}

	
	// --- GETTERS AND SETTERS: ---
	public ArrayList<Ders> getDersListesi() {
		if(dersListesi == null) {  		// lazy initializing tekniğini uyguluyoruz. --> delaying the creation or initialization of an object or resource until the point at which it is first needed. 
			this.dersListesi = new ArrayList<>();  // (Burda eğer null ise yenisini oluşturuyoruz, null değilse eskisini dönüyoruz.
		}
		return dersListesi;
	}

	public void setDersListesi(ArrayList<Ders> dersListesi) {
		this.dersListesi = dersListesi;
	}

	public boolean isNobetciMi() {
		return nobetciMi;
	}

	public void setNobetciMi(boolean nobetciMi) {
		this.nobetciMi = nobetciMi;
	}
	
	// METHODS:	
	@Override
	public void menu() {		
		super.menu();
		System.out.println("*** Öğretmen İşlemleri ***");
		System.out.println("1- Girdiğim derleri listele");
		System.out.println("2- Nöbetçilik durumu sorgula");
	}
	
	
	
	
}
