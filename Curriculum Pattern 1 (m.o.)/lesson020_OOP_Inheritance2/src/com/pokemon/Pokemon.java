package com.pokemon;

public class Pokemon {
	private long id;
	private String ad;
	private String tur;
	private int can;
	private int guc;
	private int derece;
	private String[] zayifliklar;
	private Kullanici kullanici;
	
	// Constructor
	public Pokemon() { 
		can = 100;
	}
	
	// Parametreli Constructor
	public Pokemon(long myId, String pokemonIsmi, String pokemonTuru, int pokemonCani, int pokemonGucu, int pokemonDerecesi) {
//		this();
		id = myId;
		ad = pokemonIsmi;
		tur = pokemonTuru;
		can = pokemonCani;
		guc = pokemonGucu;	
		derece = pokemonDerecesi;
	}
	
	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public int getCan() {
		return can;
	}

	public void setCan(int can) {
		this.can = can;
	}

	public int getGuc() {
		return guc;
	}

	public void setGuc(int guc) {
		this.guc = guc;
	}

	public int getDerece() {
		return derece;
	}

	public void setDerece(int derece) {
		this.derece = derece;
	}

	public String[] getZayifliklar() {
		return zayifliklar;
	}

	public void setZayifliklar(String[] zayifliklar) {
		this.zayifliklar = zayifliklar;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	// --- Methods: ---
	public void pokedex() {
		System.out.println("***** POKEDEX: *****");		
		System.out.println("id.....: " + id);
		System.out.println("ad.....: " + ad);
		System.out.println("tür....: " + tur);
		System.out.println("can....: " + can);
		System.out.println("güç....: " + guc);
		System.out.println("derece.: " + derece);
	}

	
}
