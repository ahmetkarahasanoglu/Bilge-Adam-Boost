package com.pokemon;

public class Test {

	public static void main(String[] args) {
		
		Pokemon pokemon = new Pokemon();
		pokemon.ad = "Charizard";
		pokemon.derece = 3;
		pokemon.id = 1;
		pokemon.guc = 220;
		pokemon.tur = "Ateş";		
		pokemon.pokedex();
		
		AtesPokemonu atesPokemonu = new AtesPokemonu();
		atesPokemonu.ad = "Charmender";
		atesPokemonu.derece = 2;
		atesPokemonu.id = 2;
		atesPokemonu.can = 80;
		atesPokemonu.guc = 120;
		atesPokemonu.tur = "Ateş";
		atesPokemonu.yakicilikGucu = 50;
		atesPokemonu.zayifliklar = new String[2];
		atesPokemonu.zayifliklar[0] = "Su";
		atesPokemonu.zayifliklar[1] = "Hava";
		atesPokemonu.pokedex();
		
		Pokemon pokemon2 = new Pokemon(3, "Pikachu", "Elektrik", 150, 300);
		pokemon2.pokedex();
		
//		SuPokemonu suPokemonu = new SuPokemonu();	
		suPokemonu.pokedex();
		
	}//main ends here

}//class ends here
