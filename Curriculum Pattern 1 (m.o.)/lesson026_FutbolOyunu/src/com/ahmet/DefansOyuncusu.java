package com.ahmet;

import java.util.Random;

public class DefansOyuncusu extends AktifFutbolcu {
	private int pozisyonAlma;
	private int kafa;
	private int sicrama;
	
	
	// CONSTRUCTOR
	public DefansOyuncusu(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.pozisyonAlma = generateRandomSkillPoint();
		this.kafa = generateRandomSkillPoint();
		this.sicrama = generateRandomSkillPoint();
		this.setAdSoyad("defans" + StaticValues.generateSeqNumDefans());
		this.setFormaNo(StaticValues.generateFormaNoDefans());
	}
	
	
	// GETTERS AND SETTERS:
	public int getPozisyonAlma() {
		return pozisyonAlma;
	}
	public void setPozisyonAlma(int pozisyonAlma) {
		this.pozisyonAlma = pozisyonAlma;
	}
	public int getKafa() {
		return kafa;
	}
	public void setKafa(int kafa) {
		this.kafa = kafa;
	}
	public int getSicrama() {
		return sicrama;
	}
	public void setSicrama(int sicrama) {
		this.sicrama = sicrama;
	}

	
	// METHODS: ----------
	@Override
	public String toString() {
		return "DefansOyuncusu [pozisyonAlma=" + pozisyonAlma + ", kafa=" + kafa + ", sicrama=" + sicrama
				+ ", getAdSoyad()=" + getAdSoyad() + ", getFormaNo()=" + getFormaNo() + ", getDayaniklilik()="
				+ getDayaniklilik() + ", getHiz()=" + getHiz() + ", getPas()=" + getPas() + ", getSut()=" + getSut()
				+ ", getYetenek()=" + getYetenek() + ", getKararlilik()=" + getKararlilik() + ", getDogalForm()="
				+ getDogalForm() + ", getSans()=" + getSans() + "]";
	}

	@Override
	public int generateRandomSkillPoint() {
		Random random = new Random();
		return random.nextInt(60,91);
	}

	public int pasSkoruHesapla() {
		Random random = new Random();
		int bonus = random.nextInt(0,4);
		double result = this.getPas()*0.2 + this.getYetenek()*0.2 + this.getDayaniklilik()*0.1 + this.getDogalForm()*0.1 + this.getPozisyonAlma()*0.1 + this.getSans()*0.2 + bonus;		
		System.out.println("Pas Skoru: " + (int)result);
		return (int)result;
	}

	@Override
	public int golSkoruHesapla(int kurtaris) {
		Random random = new Random();		
		double bonus = random.nextInt(2, 5) * this.getDogalForm() * 0.075;
		double result = this.getYetenek()*0.3 + this.getSut()*0.2 + this.getKararlilik()*0.1 + this.getSans()*0.1 + kafa*0.1 + this.getDogalForm()*0.1 + bonus - kurtaris;
		return (int)result;		
	}
	
}
