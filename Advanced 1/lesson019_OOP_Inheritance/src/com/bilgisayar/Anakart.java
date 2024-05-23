package com.bilgisayar;

public class Anakart extends DahiliDonanim {
	
	Islemci islemci;
	Ram ram;
	
	public Anakart() {
	}
	public Anakart(Islemci islemcim, Ram ramim) {
		islemci = islemcim;
		ram = ramim;
	}
	public Anakart(Islemci islemcim) {
		islemci = islemcim;
	}
}
