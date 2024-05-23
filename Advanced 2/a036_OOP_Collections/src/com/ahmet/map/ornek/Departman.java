package com.ahmet.map.ornek;

public class Departman {

	Long id;
	String ad;
	
	// CONSTRUCTOR:
	public Departman(Long id, String ad) {
		super();
		this.id = id;
		this.ad = ad;
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

	// METHODS: --------
	@Override
	public String toString() {
		return "Departman [id=" + id + ", ad=" + ad + "]";
	}
	
	
	
	
	
}
