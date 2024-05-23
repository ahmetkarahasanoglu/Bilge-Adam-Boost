package com.ahmet;

import java.util.Random;

public class OrtaSahaOyuncusu extends AktifFutbolcu {
	private int uzunTop;
	private int ilkDokunus;
	private int topSurme;
	private int uretkenlik;
	private int ozelYetenek;
	
	
	// CONSTRUCTOR:
	public OrtaSahaOyuncusu(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.uzunTop = generateRandomSkillPoint();
		this.ilkDokunus = generateRandomSkillPoint();
		this.topSurme = generateRandomSkillPoint();
		this.uretkenlik = generateRandomSkillPoint();
		this.ozelYetenek = generateRandomSkillPoint();
		this.setAdSoyad("ortasaha" + StaticValues.generateSeqNumOrtaSaha());
		this.setFormaNo(StaticValues.generateFormaNoOrtaSaha());
	}
	
	
	// GETTERS AND SETTERS:
	public int getUzunTop() {
		return uzunTop;
	}
	public void setUzunTop(int uzunTop) {
		this.uzunTop = uzunTop;
	}
	public int getIlkDokunus() {
		return ilkDokunus;
	}
	public void setIlkDokunus(int ilkDokunus) {
		this.ilkDokunus = ilkDokunus;
	}
	public int getTopSurme() {
		return topSurme;
	}
	public void setTopSurme(int topSurme) {
		this.topSurme = topSurme;
	}
	public int getUretkenlik() {
		return uretkenlik;
	}
	public void setUretkenlik(int uretkenlik) {
		this.uretkenlik = uretkenlik;
	}
	public int getOzelYetenek() {
		return ozelYetenek;
	}
	public void setOzelYetenek(int ozelYetenek) {
		this.ozelYetenek = ozelYetenek;
	}


	// METHODS: ---------
	@Override
	public String toString() {
		return "OrtaSahaOyuncusu [uzunTop=" + uzunTop + ", ilkDokunus=" + ilkDokunus + ", topSurme=" + topSurme
				+ ", uretkenlik=" + uretkenlik + ", ozelYetenek=" + ozelYetenek + ", getAdSoyad()=" + getAdSoyad()
				+ ", getFormaNo()=" + getFormaNo() + ", getDayaniklilik()=" + getDayaniklilik() + ", getHiz()="
				+ getHiz() + ", getPas()=" + getPas() + ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek()
				+ ", getKararlilik()=" + getKararlilik() + ", getDogalForm()=" + getDogalForm() + ", getSans()="
				+ getSans() + "]";
	}

	@Override
	public int generateRandomSkillPoint() {
		Random random = new Random();
		return random.nextInt(60,101);
	}

	public int pasSkoruHesapla() {
		Random random = new Random();
		int bonus = random.nextInt(1,8);
		double result = this.getPas()*0.2 + this.getYetenek()*0.2 + this.getOzelYetenek()*0.2 + this.getDayaniklilik()*0.1 + this.getDogalForm()*0.1 + this.getSans()*0.1 + bonus;
		System.out.println("Pas Skoru: " + (int)result);
		return (int)result;
	}


	@Override
	public int golSkoruHesapla(int kurtaris) {
		Random random = new Random();		
		double bonus = random.nextInt(1, 6) * this.getDogalForm() * 0.075;
		double result = this.getYetenek()*0.2 + this.ozelYetenek*0.2 + this.getSut()*0.2 + this.ilkDokunus*0.1 + this.getKararlilik()*0.1 + this.getSans()*0.1 + this.getDogalForm()*0.1 + bonus - kurtaris;
		return (int)result;	
	}
	
	
	
}
