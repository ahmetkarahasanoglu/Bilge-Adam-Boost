package com.ahmet;

import java.util.Random;

public class ForvetOyuncusu extends AktifFutbolcu {
	int bitiricilik;
	int ilkDokunus;
	int kafa;
	int ozelYetenek;
	
	
	// CONSTRUCTOR:
	public ForvetOyuncusu(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.bitiricilik = generateRandomSkillPoint();
		this.ilkDokunus = generateRandomSkillPoint();
		this.kafa = generateRandomSkillPoint();
		this.ozelYetenek = generateRandomSkillPoint();
		this.setAdSoyad("forvet" + StaticValues.generateSeqNumForvet());
		this.setFormaNo(StaticValues.generateFormaNoForvet());
	}

	// GETTERS AND SETTERS:
	public int getBitiricilik() {
		return bitiricilik;
	}

	public void setBitiricilik(int bitiricilik) {
		this.bitiricilik = bitiricilik;
	}

	public int getIlkDokunus() {
		return ilkDokunus;
	}

	public void setIlkDokunus(int ilkDokunus) {
		this.ilkDokunus = ilkDokunus;
	}

	public int getKafa() {
		return kafa;
	}

	public void setKafa(int kafa) {
		this.kafa = kafa;
	}

	public int getOzelYetenek() {
		return ozelYetenek;
	}

	public void setOzelYetenek(int ozelYetenek) {
		this.ozelYetenek = ozelYetenek;
	}

	
	// METHODS: ----------
	@Override
	public String toString() {
		return "ForvetOyuncusu [bitiricilik=" + bitiricilik + ", ilkDokunus=" + ilkDokunus + ", kafa=" + kafa
				+ ", ozelYetenek=" + ozelYetenek + ", getAdSoyad()=" + getAdSoyad() + ", getFormaNo()=" + getFormaNo()
				+ ", getDayaniklilik()=" + getDayaniklilik() + ", getHiz()=" + getHiz() + ", getPas()=" + getPas()
				+ ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek() + ", getKararlilik()=" + getKararlilik()
				+ ", getDogalForm()=" + getDogalForm() + ", getSans()=" + getSans() + "]";
	}

	@Override
	public int generateRandomSkillPoint() {
		Random random = new Random();
		return random.nextInt(70,101);
	}
	
	public int pasSkoruHesapla() {
		Random random = new Random();
		int bonus = random.nextInt(1,6);
		double result = this.getPas()*0.2 + this.getYetenek()*0.2 + this.getOzelYetenek()*0.2 + this.getDayaniklilik()*0.1 + this.getDogalForm()*0.1 + this.getSans()*0.1 + bonus;
		System.out.println("Pas Skoru: " + (int)result);
		return (int)result;
	}

	@Override
	public int golSkoruHesapla(int kurtaris) {
		Random random = new Random();		
		double bonus = random.nextInt(1, 5) * this.getDogalForm() * 0.075;
		double result = this.getYetenek()*0.2 + this.ozelYetenek*0.2 + this.getSut()*0.1 + this.ilkDokunus*0.1 + this.getKararlilik()*0.1 + this.getSans()*0.1 + this.kafa*0.1 + this.bitiricilik*0.2 + this.getDogalForm()*0.1 + bonus - kurtaris;
		return (int)result;	
	}
	

}
