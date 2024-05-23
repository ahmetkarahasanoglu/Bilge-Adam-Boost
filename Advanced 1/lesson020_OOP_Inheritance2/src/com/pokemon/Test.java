package com.pokemon;

public class Test {

	public static void main(String[] args) {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setAd("Charizard");
		pokemon.setDerece(3);
		pokemon.setId(1);
		pokemon.setGuc(220);
		pokemon.setTur("Ateş");		
//		pokemon.pokedex();
		
		AtesPokemonu atesPokemonu = new AtesPokemonu();
//		String[] array = new String[] {"Su", "Hava"};
		String[] array = new String[2];
		atesPokemonu.setZayifliklar(array);
		atesPokemonu.getZayifliklar()[0] = "Su"; // Bu şekilde "zayifliklar" dizisinin elemanlarına atama yapabiliyorum.
		atesPokemonu.getZayifliklar()[1] = "Hava";
//		System.out.println("zayifliklar[0]: " + atesPokemonu.getZayifliklar()[0]);
//		atesPokemonu.pokedex();		
//		System.out.println(atesPokemonu.getYakicilikGucu());
		
		AtesPokemonu atesPokemonu2 = new AtesPokemonu(3, "Firezard", "Ateş", 90, 140, 200, 250);
//		atesPokemonu2.pokedex();
//		System.out.println(atesPokemonu2.getYakicilikGucu());
		AtesPokemonu atesPokemonu3 = new AtesPokemonu();
//		atesPokemonu3.pokedex();
		
		Pokemon pokemon2 = new Pokemon(3, "Pikachu", "Elektrik", 150, 300, 120);
//		pokemon2.pokedex();
		
		SuPokemonu suPokemonu = new SuPokemonu(4, "Squirtle", "Su Pokemonu", 200, 180, 2, 110, 150);
		suPokemonu.pokedex();
		
	}//main ends here

}//class ends here
