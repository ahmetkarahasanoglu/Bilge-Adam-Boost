package com.ahmet;

import java.util.Random;

/*
 * ÖNEMLİ !!!!! : Futbolcu sınıfını abstract sınıf olarak 
 * tanımladık. Çünkü biz Futbolcu sınıfından bir nesne
 * oluşturmayacağız, onun alt sınıflarından oluşturacağız.
 * Bir blueprint olarak düşünebiliriz Futbolcu sınıfını.
 */
public abstract class Futbolcu { 
	private String adSoyad;
	private int formaNo;
	private int dayaniklilik;
	private int hiz;
	private int pas;
	private int sut;
	private int yetenek;
	private int kararlilik;
	private int dogalForm;
	private int sans;
	
	
	// CONSTRUCTOR
	public Futbolcu(String adSoyad, int formaNo) {
		super();
		this.adSoyad = adSoyad;
		this.formaNo = formaNo;
		this.dayaniklilik = generateRandomSkillPoint();
		this.hiz = generateRandomSkillPoint();
		this.pas = generateRandomSkillPoint();
		this.sut = generateRandomSkillPoint();
		this.yetenek = generateRandomSkillPoint();
		this.kararlilik = generateRandomSkillPoint();
		this.dogalForm = generateRandomSkillPoint();
		this.sans = generateRandomSkillPoint();
	}
	
	
	// GETTERS AND SETTERS
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public int getFormaNo() {
		return formaNo;
	}
	public void setFormaNo(int formaNo) {
		this.formaNo = formaNo;
	}
	public int getDayaniklilik() {
		return dayaniklilik;
	}
	public void setDayaniklilik(int dayaniklilik) {
		this.dayaniklilik = dayaniklilik;
	}
	public int getHiz() {
		return hiz;
	}
	public void setHiz(int hiz) {
		this.hiz = hiz;
	}
	public int getPas() {
		return pas;
	}
	public void setPas(int pas) {
		this.pas = pas;
	}
	public int getSut() {
		return sut;
	}
	public void setSut(int sut) {
		this.sut = sut;
	}
	public int getYetenek() {
		return yetenek;
	}
	public void setYetenek(int yetenek) {
		this.yetenek = yetenek;
	}
	public int getKararlilik() {
		return kararlilik;
	}
	public void setKararlilik(int kararlilik) {
		this.kararlilik = kararlilik;
	}
	public int getDogalForm() {
		return dogalForm;
	}
	public void setDogalForm(int dogalForm) {
		this.dogalForm = dogalForm;
	}
	public int getSans() {
		return sans;
	}
	public void setSans(int sans) {
		this.sans = sans;
	}


	// METHODS: -----------	
	public int generateRandomSkillPoint() {
		Random random = new Random();
		int randNum = random.nextInt(50, 101);
		return randNum;
	}
	
	
}
