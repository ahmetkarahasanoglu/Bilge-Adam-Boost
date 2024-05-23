package com.okulyonetimsistemi;

public class Kisi {
	
	private String isim;
	private String soyisim;
	private String adres;
	
	
	// CONSTRUCTOR 1:
	public Kisi() {
		super();
	}

	// CONSTRUCTOR 2:
	public Kisi(String isim, String soyisim) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
	}	
	
	// CONSTRUCTOR 3:
	public Kisi(String isim, String soyisim, String adres) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.adres = adres;
	}
	

	// --- GETTERS AND SETTERS: ---
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}	
	
	
	// METHODS:
	public void menu() {
		System.out.println(isim + " OKUL YÖNETİM SİSTEMİNE HOŞGELDİNİZ.");
		
	}
	
	
	
	
}
