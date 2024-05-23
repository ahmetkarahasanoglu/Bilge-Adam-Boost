package com.ahmet;

import com.ahmet.entities.Car;
import com.ahmet.entities.Entity;

public class Runner {

	public static void main(String[] args) {
		
/*
 * Bir otomasyon programını örnekleyerek (hastane, petrol ofisi, 
 * müşteri takip, stok takip gibi); 3 adet entity ve bunlara miras veren 
 * 1 parent ile;
 * 		a- encapsulation
 * 		b- constructor
 * 		c- overloading - overriding
 * 		d- this, super
 * maddelerini içeren bir örnek yapınız. 
 */		
		// CAR RENTAL SYSTEM
		
		Entity entity = new Entity();
		System.out.println(entity.getUuid().toString());
		System.out.println(entity.getId());
		
		System.out.println("--------------------------------");
		
		Car car1 = new Car();
		car1.setBrand("Toyota");
		car1.setModel("Corolla");

		Car car2 = new Car();
		car2.setBrand("Ford");
		car2.setModel("Mustang");
		
		System.out.println(car1.getBrand() + " " + car1.getModel());
		System.out.println(car2.getBrand() + " " + car2.getModel());
		
	}//main ends here

}//class ends here
