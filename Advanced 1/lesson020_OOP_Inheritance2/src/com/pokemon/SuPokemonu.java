package com.pokemon;

public class SuPokemonu extends Pokemon {
	int suBasincGucu;
	int yuzmeHizi;
	
	
	// Constructor:
	public SuPokemonu(long myId, String pokemonIsmi, String pokemonTuru, int pokemonCani, int pokemonGucu,
			int pokemonDerecesi, int suBasincGucu, int yuzmeHizi) {
		super(myId, pokemonIsmi, pokemonTuru, pokemonCani, pokemonGucu, pokemonDerecesi);
		this.suBasincGucu = suBasincGucu;
		this.yuzmeHizi = yuzmeHizi;
	}
	
	// --- Methods: ---
	@Override
	public void pokedex() {
		super.pokedex();
		System.out.println("Su basınç gücü: " + suBasincGucu);
		System.out.println("Yüzme hızı: " + yuzmeHizi);
	}


}
