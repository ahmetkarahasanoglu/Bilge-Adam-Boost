package com.ahmet.entity2;

public class Araba extends Arac {

	@Override  //  "override" is used in inheritance. It is the term used to indicate that a subclass is providing a specific implementation of a method that is already defined in its superclass. "Override" is used when you want to provide a new implementation for a method in a subclass that has the same signature (method name, parameters, and return type) as a method in its superclass.
	public void hizlan() {
		hiz += 3;
	}
	
}
