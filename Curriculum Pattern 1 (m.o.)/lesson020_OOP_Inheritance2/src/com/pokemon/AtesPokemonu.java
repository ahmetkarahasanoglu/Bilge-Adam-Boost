package com.pokemon;

public class AtesPokemonu extends Pokemon {
	private int yakicilikGucu;
	
	// Default Constructor:
	public AtesPokemonu() {
	} // '--> automatically 'super()' works here.
	
	// Constructor with Parameter:
	public AtesPokemonu(long myId, String pokemonIsmi, String pokemonTuru, int pokemonCani, int pokemonGucu, int pokemonDerecesi, int yakicilikGucu) {
		super(myId, pokemonIsmi, pokemonTuru, pokemonCani, pokemonGucu, pokemonDerecesi);
		this.yakicilikGucu = yakicilikGucu;
	}
	
	
	// Getters & Setters:
	public int getYakicilikGucu() {
		return yakicilikGucu;
	}

	public void setYakicilikGucu(int yakicilikGucu) {
		this.yakicilikGucu = yakicilikGucu;
	}	
	
	// --- Methods: ---
	@Override
	public void pokedex() {	
		super.pokedex();
		System.out.println("***** POKEDEX: *****");		
		System.out.println("id.....: " + this.getId());
		System.out.println("ad.....: " + this.getAd());
		System.out.println("tür....: " + this.getTur());
		System.out.println("can....: " + this.getCan());
		System.out.println("güç....: " + this.getGuc());
		System.out.println("derece.: " + this.getDerece());
		System.out.println("yakcGuc: " + yakicilikGucu);
	}
	
	
	
	
	
}
