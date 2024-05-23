package com.ahmet;

public class Mudur extends Personel {
	
	public static int derece;
	
	// CONSTRUCTOR:
	public Mudur() { // there is an implicit 'super()' in this block.
		System.out.println("Müdür constructor'ı çalıştı.");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personel delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
