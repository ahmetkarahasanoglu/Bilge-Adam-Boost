package com.ahmet.entity_animals;

public class NonFlyingBirds extends Birds {
	public int maxRunningSpeed;

	@Override
	public String toString() {
		return "NonFlyingBirds [maxRunningSpeed=" + maxRunningSpeed + "]";
	}

	public void run() {
		System.out.println(this.nameOfSpecies + " is running.");
	}
}
