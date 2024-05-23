package com.ahmet.repository.entity;

public class Konu extends BaseEntity {

	String dersId; // Doğru yöntem budur. Sınıflar arasındaki ilişkiyi tutmanın doğru yöntemi bu şekilde id'ler arasında bağlantı kurmaktır.
	String ad;
	Ders ders; // Farklı bir yaklaşım olarak; ilişkide olduğu entity, sınıf içinde tutularak da yapılabilir. Bu yöntem çok yer kaplar, çünkü kopyaları pek çok yerde tutmak durumundayız.	
	
	
	// CONSTRUCTOR 1:
	public Konu() {
		super();
	}

	// CONSTRUCTOR 2:
	public Konu(String dersId, String ad, Ders ders) {
		super();
		this.dersId = dersId;
		this.ad = ad;
		this.ders = ders;
	}
	
	// GETTERS AND SETTERS:
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getDersId() {
		return dersId;
	}
	public void setDersId(String dersId) {
		this.dersId = dersId;
	}
	public Ders getDers() {
		return ders;
	}
	public void setDers(Ders ders) {
		this.ders = ders;
	}
	
	
	
}
