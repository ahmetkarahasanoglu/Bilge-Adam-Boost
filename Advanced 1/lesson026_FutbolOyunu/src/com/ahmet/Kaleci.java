package com.ahmet;

import java.util.Random;

public class Kaleci extends Futbolcu {
	
	private int kurtaris;

	
	
	// CONSTRUCTOR:
	public Kaleci(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.kurtaris = generateRandomSkillPoint();
		this.setAdSoyad("kaleci");
		this.setFormaNo(1);
	}

	// GETTERS AND SETTERS:
	public int getKurtaris() {
		return kurtaris;
	}

	public void setKurtaris(int kurtaris) {
		this.kurtaris = kurtaris;
	}

	
	// METHODS: ---------
	@Override
	public String toString() {
		return "Kaleci [kurtaris=" + kurtaris + ", getAdSoyad()=" + getAdSoyad() + ", getFormaNo()=" + getFormaNo()
				+ ", getDayaniklilik()=" + getDayaniklilik() + ", getHiz()=" + getHiz() + ", getPas()=" + getPas()
				+ ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek() + ", getKararlilik()=" + getKararlilik()
				+ ", getDogalForm()=" + getDogalForm() + ", getSans()=" + getSans() + "]";
	}

	@Override
	public int generateRandomSkillPoint() {
		Random random = new Random();
		return random.nextInt(65,101);
	}
	
	public int kurtarisSkoruHesapla() {
		Random random = new Random();
		double bonus = random.nextInt(1, 5) * this.getDogalForm() * 0.025;
		double result = this.kurtaris*0.2 + this.getKararlilik()*0.1 + bonus;
		return (int)result;
	}

	
}
