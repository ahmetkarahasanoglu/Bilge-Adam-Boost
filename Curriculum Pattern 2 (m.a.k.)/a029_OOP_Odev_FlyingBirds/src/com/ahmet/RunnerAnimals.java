package com.ahmet;

import com.ahmet.entity_animals.FlyingBirds;
import com.ahmet.entity_animals.NonFlyingBirds;

public class RunnerAnimals {

	public static void main(String[] args) {
		
/*
 * 1- Canlılar dünyasını düşünerek, herhangi bir konuda kalıtım
 * ile ilgili kodlama yapınız. Örneğin: Kuşlar -> uçabilen kuşlar, 
 * uçamayan kuşlar. (3 seviye kadar alta inin)
 */

		FlyingBirds eagle = new FlyingBirds();
		eagle.nameOfSpecies = "Eagle";
		eagle.length = 0.9;
		eagle.foods = new String[] { "sworms", "rodents", "other small birds" };
		eagle.eatFood();
		eagle.eatFood(eagle.foods[0]);
		eagle.fly();
		System.out.println(eagle.toString()); 
		
		NonFlyingBirds ostrich = new NonFlyingBirds();
		ostrich.nameOfSpecies = "Ostrich";
		ostrich.maxRunningSpeed = 50;
		ostrich.run();
		System.out.println(ostrich.toString()); 
		
	}

}
