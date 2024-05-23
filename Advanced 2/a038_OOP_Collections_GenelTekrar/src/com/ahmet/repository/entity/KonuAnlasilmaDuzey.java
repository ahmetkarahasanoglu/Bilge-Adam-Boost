package com.ahmet.repository.entity;

public class KonuAnlasilmaDuzey {
	Konu konu;
	EKonuDuzey konuDuzey;
	int cozulenSoruSayisi;
	int dogruYanitSayisi;
	int yuzde;
	
	
	// CONSTRUCTOR 1:
	public KonuAnlasilmaDuzey() {
		
	}
	
	// CONSTRUCTOR 2:
	public KonuAnlasilmaDuzey(Konu konu, EKonuDuzey konuDuzey, int cozulenSoruSayisi, int dogruYanitSayisi, int yuzde) {
		super();
		this.konu = konu;
		this.konuDuzey = konuDuzey;
		this.cozulenSoruSayisi = cozulenSoruSayisi;
		this.dogruYanitSayisi = dogruYanitSayisi;
		this.yuzde = yuzde;
	}
	// GETTERS AND SETTERS:
	public Konu getKonu() {
		return konu;
	}
	public void setKonu(Konu konu) {
		this.konu = konu;
	}
	public EKonuDuzey getKonuDuzey() {
		return konuDuzey;
	}
	public void setKonuDuzey(EKonuDuzey konuDuzey) {
		this.konuDuzey = konuDuzey;
	}
	public int getCozulenSoruSayisi() {
		return cozulenSoruSayisi;
	}
	public void setCozulenSoruSayisi(int cozulenSoruSayisi) {
		this.cozulenSoruSayisi = cozulenSoruSayisi;
	}
	public int getDogruYanitSayisi() {
		return dogruYanitSayisi;
	}
	public void setDogruYanitSayisi(int dogruYanitSayisi) {
		this.dogruYanitSayisi = dogruYanitSayisi;
	}
	public int getYuzde() {
		return yuzde;
	}
	public void setYuzde(int yuzde) {
		this.yuzde = yuzde;
	}
	
	
	// METHODS: -----------
	@Override
	public String toString() {
		return "KonuAnlasilmaDuzey [konu=" + konu + ", konuDuzey=" + konuDuzey + ", cozulenSoruSayisi="
				+ cozulenSoruSayisi + ", dogruYanitSayisi=" + dogruYanitSayisi + ", yuzde=" + yuzde + "]";
	}
	
	
}
