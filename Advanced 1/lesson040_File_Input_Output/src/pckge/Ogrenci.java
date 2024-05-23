package pckge;

import java.io.Serializable;

public class Ogrenci implements Serializable { // pay att: Serializable'ı implement ettik.

	private static final long serialVersionUID = 1L; // Automatically came from Serializable.
	private String isim;
	private int yas;
	
	// CONSTRUCTOR:
	public Ogrenci(String isim, int yas) {
		super();
		this.isim = isim;
		this.yas = yas;
	}

	// GETTERS AND SETTERS:
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	@Override
	public String toString() {
		return "Ogrenci [isim=" + isim + ", yas=" + yas + "]";
	}
	
	
	
	
}
