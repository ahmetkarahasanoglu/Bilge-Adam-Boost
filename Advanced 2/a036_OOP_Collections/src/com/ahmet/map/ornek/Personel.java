package com.ahmet.map.ornek;

public class Personel {
	
	Long id;
	String ad;
	String telefon;
	Departman departman;
	
	// CONSTRUCTOR:
	public Personel(Long id, String ad, String telefon, Departman departman) {
		super();
		this.id = id;
		this.ad = ad;
		this.telefon = telefon;
		this.departman = departman;
	}

	// GETTERS AND SETTERS:
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Departman getDepartman() {
		return departman;
	}

	public void setDepartman(Departman departman) {
		this.departman = departman;
	}

	// METHODS: --------------
	@Override
	public String toString() {
		return "Personel [id=" + id + ", ad=" + ad + ", telefon=" + telefon + ", departman=" + departman + "]";
	}
	
	
	
	
	
}
