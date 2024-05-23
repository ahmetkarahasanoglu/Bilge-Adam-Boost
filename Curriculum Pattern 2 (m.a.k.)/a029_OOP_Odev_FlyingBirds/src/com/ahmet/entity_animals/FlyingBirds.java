package com.ahmet.entity_animals;

public class FlyingBirds extends Birds {
	public int maxAltitude;
	public int maxAirSpeed;
	
	@Override
	public String toString() {
		return "FlyingBirds [maxAltitude=" + maxAltitude + ", maxAirSpeed=" + maxAirSpeed + "]";
	}

	public void fly() {
		System.out.println(this.nameOfSpecies + " is flying.");
	}
}
