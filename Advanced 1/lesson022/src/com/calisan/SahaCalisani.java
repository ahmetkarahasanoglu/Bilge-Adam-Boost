package com.calisan;
// Bu sınıf, sahaya çıkan çalışanları temsil ediyor.
public class SahaCalisani extends Personel implements IHarcOdeme {

	
	// CONSTRUCTOR 1:
	public SahaCalisani(String isim, String soyisim) {
		super(isim, soyisim);
		// TODO Auto-generated constructor stub
	}
	
	// CONSTRUCTOR 2:
	public SahaCalisani(String isim, String soyisim, double maas) {
		super(isim, soyisim, maas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void harcOde() {
		// TODO Auto-generated method stub
		
	}

	

	

	
}
