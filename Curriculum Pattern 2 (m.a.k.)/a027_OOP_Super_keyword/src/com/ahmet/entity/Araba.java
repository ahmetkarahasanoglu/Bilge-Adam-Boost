package com.ahmet.entity;

public class Araba extends Arac {
/*
 * 1- 'super' keyword: calls the inherited parent's (the super class's)
 * constructor. 
 * 2- It is used inside the constructor. 
 * 3- It doesn't allow to write code before it.
 * 4- An extended class has 'super' keyword in its constructor
 * as default, (even when you didn't write 'super' keyword)
 */
	public Araba() {
		super();	 // MARK
		System.out.println("Arabanın constructor'ı çalıştı (parametresiz default constructor)");		
	}
	
	public Araba(double aracfiyati) {
		super(aracfiyati); // PAY ATT. we used parameter !!! -MARK.
//		'--> If we didn't write 'super(aracfiyati)' here, it would
//		work as if there is a 'super()' here, which calls the DEFAULT
//		(without parameter) constructor of the super class.
		System.out.println("Arabanın parametreli constructor'ı çalıştı.");
	}
	
}
