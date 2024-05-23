package com.teacherscode;

import java.util.Random;

public class Forvet extends AktifFutbolcu {

	private int bitiricilik;
	private int ilkDokunus;
	private int kafa;
	private int ozelYetenek;

	public Forvet(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.bitiricilik = rastgeleYetenekPuanıAta();
		this.ilkDokunus = rastgeleYetenekPuanıAta();
		this.kafa = rastgeleYetenekPuanıAta();
		this.ozelYetenek = rastgeleYetenekPuanıAta();

	}

	@Override
	public int rastgeleYetenekPuanıAta() {
		Random random = new Random();
		return random.nextInt(70, 101);
	}

	public int getBitiricilik() {
		return bitiricilik;
	}

	public int getIlkDokunus() {
		return ilkDokunus;
	}

	public int getKafa() {
		return kafa;
	}

	public int getOzelYetenek() {
		return ozelYetenek;
	}

	public void setBitiricilik(int bitiricilik) {
		this.bitiricilik = bitiricilik;
	}

	public void setIlkDokunus(int ilkDokunus) {
		this.ilkDokunus = ilkDokunus;
	}

	public void setKafa(int kafa) {
		this.kafa = kafa;
	}

	public void setOzelYetenek(int ozelYetenek) {
		this.ozelYetenek = ozelYetenek;
	}

	@Override
	public String toString() {
		return "Forvet [bitiricilik=" + bitiricilik + ", ilkDokunus=" + ilkDokunus + ", kafa=" + kafa + ", ozelYetenek="
				+ ozelYetenek + ", getAdSoyad()=" + getAdSoyad() + ", getFormaNo()=" + getFormaNo()
				+ ", getDayaniklilik()=" + getDayaniklilik() + ", getHiz()=" + getHiz() + ", getPas()=" + getPas()
				+ ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek() + ", getKararlilik()=" + getKararlilik()
				+ ", getDogalForm()=" + getDogalForm() + ", getSans()=" + getSans() + "]";
	}

	@Override
	public int pasSkor() {
		Random random = new Random();
		/*
		 * Bonus= 1 ile 6 arasında rastgele bir sayıdır.
		 * pas*0.2+yetenek*0.2+ozelYetenek*0.2+dayaniklilik*0.1+dogalForm*0.1+sans*0.1+
		 * bonus
		 * 
		 * 
		 */
		int bonus = random.nextInt(1, 6);
		return (int) (getPas() * 0.2 + getYetenek() * 0.2 + ozelYetenek * 0.2 + getDayaniklilik() * 0.1
				+ getDogalForm() * 0.1 + getSans() * 0.1 + bonus);
	}

	@Override
	public int golSkor(int kurtaris) {
		/*
		 * 
		 * Bonus= 1 ile 5 arasında rastgele bir sayı * dogalForm*0.075 Kurtarış=karşı
		 * takım kalecisinden gelen kurtarış skor değeri.
		 * yetenek*0.2+ozelYetenek*0.2+sut*0.1+ilkDokunus*0.1+kararlilik*0.1+sans*0.1+
		 * kafa*0.1+bitiricilik*0.2+ dogalForm*0.1+bonus-kurtarış
		 * 
		 * 
		 * 
		 */
		Random random = new Random();
		double bonus = (random.nextDouble(1, 5) * getDogalForm() * 0.075);

		return (int) (getYetenek() * 0.2 + ozelYetenek * 0.2 + getSut() * 0.1 + +ilkDokunus * 0.1
				+ getKararlilik() * 0.1 + getSans() * 0.1 + kafa * 0.1 + bitiricilik * 0.2 + getDogalForm() * 0.1
				+ bonus - kurtaris);
	}

}
