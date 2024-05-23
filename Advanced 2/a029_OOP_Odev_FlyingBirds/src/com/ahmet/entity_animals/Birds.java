package com.ahmet.entity_animals;

import java.util.Arrays;

public class Birds extends Animals {
	public double wingSpan;	
	public String[] foods;
	
	@Override
	public String toString() {
		return "Birds [wingSpan=" + wingSpan + ", foods=" + Arrays.toString(foods) + ", nameOfSpecies=" + nameOfSpecies
				+ ", height=" + height + ", length=" + length + ", weight=" + weight + ", formOfBreathing="
				+ formOfBreathing + ", formOfBloodCirculation=" + formOfBloodCirculation + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public void eatFood() {
		System.out.println(this.nameOfSpecies + " is eating food."); 
	}
	
	public void eatFood(String food) {
		System.out.println(this.nameOfSpecies + " is eating its food. The food is: " + food); 
	}
}
