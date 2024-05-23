package com.ahmet.entity;

public class Kedi {
	
	public String tur;
	public Integer agirlik;
	public Integer boy;
	public String tuy;
	public String gozrengi;
	public String kuyrukuzunlugu;
	public String konumx;
	public String konumy;
	
	/*
	 * Default Constructor 
	 * Her sınıfta bulunur fakat görünmez.
	 * Constructor'ların en önemli özelliği sınıfa ait bir nesnenin
	 * referansını döner.
	 */
	public Kedi() { // constructor
		System.out.println("Constructor çalıştı.");
		agirlik = 5; // kedi nesnesi oluştuğunda otomatik olarak var olacak özellikler.
		tur = "Ankara";
		boy = 15;
	}
	
	public void Selamla() {
		System.out.println("Miyawww");
	}
	
	public String Pisicik() {
		System.out.println("Pisicik metodunun içi çalıştı.");
		return "Miyaw";
	}
	
	public void yuru(String yon, int adim) {
		if(yon.equals("doğu")) {
			konumx += adim;
		}
	}
}
