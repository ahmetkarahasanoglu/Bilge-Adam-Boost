package com.pokemon;

public class Pokemon {
	long id;
	String ad;
	String tur;
	int can;
	int guc;
	int derece;
	String[] zayifliklar;
	Kullanici kullanici;
	
	public Pokemon() { // constructor
		can = 100;
	}
	
	// Parametreli constructor
	public Pokemon(long myId, String pokemonIsmi, String pokemonTuru, int pokemonCani, int pokemonGucu) {
		id = myId;
		ad = pokemonIsmi;
		tur = pokemonTuru;
		can = pokemonCani;
		guc = pokemonGucu;		
	}
	
	public void pokedex() {
		System.out.println("***** POKEDEX: *****");		
		System.out.println("id.....: " + id);
		System.out.println("ad.....: " + ad);
		System.out.println("tür....: " + tur);
		System.out.println("can....: " + can);
		System.out.println("güç....: " + guc);
		System.out.println("derece.: " + derece);
		System.out.println("--------------------");
	}
}
