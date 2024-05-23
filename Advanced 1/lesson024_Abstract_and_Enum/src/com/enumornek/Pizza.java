package com.enumornek;
/*
 * Pizzanın:
 * boy,
 * fiyatı,
 * malzemeleri,
 * tür (ad)
 * hamur tipi
 */
public class Pizza {
	
	ETur tur;
	EBoyut boyut;
	EHamurTipi hamurTipi;
	double fiyat;
	String[] malzemeler;
	
	// CONSTRUCTOR:
	public Pizza(ETur tur, EBoyut boyut, EHamurTipi hamurTipi) {
		super();
		this.tur = tur;
		this.boyut = boyut;
		this.hamurTipi = hamurTipi;
	}

	@Override
	public String toString() {
		return "Pizza [tur=" + tur + ", boyut=" + boyut + ", hamurTipi=" + hamurTipi + ", fiyat=" + fiyat + "]";
	}
	
	
	
}
