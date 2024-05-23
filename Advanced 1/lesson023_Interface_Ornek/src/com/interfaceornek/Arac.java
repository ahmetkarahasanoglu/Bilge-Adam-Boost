package com.interfaceornek;

public class Arac implements IHareket {

	@Override
	public void ilerle() {
		System.out.println("Araç hareket ediyor.");
		
	}

	@Override
	public void dur() {
		System.out.println("Araç durdu.");
		
	}

}
