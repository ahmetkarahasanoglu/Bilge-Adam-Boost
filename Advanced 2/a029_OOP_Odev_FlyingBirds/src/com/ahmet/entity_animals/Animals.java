package com.ahmet.entity_animals;

public class Animals {
	public String nameOfSpecies;
	public 	double height;
	public double length;
	public double weight;
	public String formOfBreathing;
	public String formOfBloodCirculation;
	
	@Override
	public String toString() {
		return "Animals [nameOfSpecies=" + nameOfSpecies + ", height=" + height + ", length=" + length + ", weight="
				+ weight + ", formOfBreathing=" + formOfBreathing + ", formOfBloodCirculation=" + formOfBloodCirculation
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
}
