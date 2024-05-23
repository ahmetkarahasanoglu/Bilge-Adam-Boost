package com.abstractornek;
// NOT: Interface'ler için: 1'den fazla interface implement edebiliriz.
// Inheritance için: tek bir sınıftan extend edebiliriz.

// NOT: Bir interface bir interface'i ancak extend edebilir,
//      ama implement edemez.
public class Bisiklet extends Arac implements IBinilebilir {  // Birden fazla interface implement ettik.

	@Override
	public void ilerle() {
		System.out.println("Bisiklet hareket ediyor.");
	}

	@Override
	public void dur() {
		System.out.println("Bisiklet durdu.");
		
	}

	@Override
	public void bin() {
		// TODO Auto-generated method stub
		System.out.println("Bisiklet biniliyor.");
	}

	
	
}
