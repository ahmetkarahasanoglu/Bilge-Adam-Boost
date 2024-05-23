package pckge;

import java.io.Serializable;

public class Ogrenci implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	double ort;
	
	// CONSTRUCTOR 1:
	public Ogrenci(String name) {
		super();
		this.name = name;
	}

	// CONSTRUCTOR 2:
	public Ogrenci(String name, double ort) {
		super();
		this.name = name;
		this.ort = ort;
	}

	// GETTERS AND SETTERS:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOrt() {
		return ort;
	}

	public void setOrt(double ort) {
		this.ort = ort;
	}

	// METHODS: ----
	@Override
	public String toString() {
		return "Ogrenci [name=" + name + ", ort=" + ort + "]";
	}

	
	
	
	
	
	
}
