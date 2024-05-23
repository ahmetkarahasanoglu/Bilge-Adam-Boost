package pckge;

import java.time.LocalDate;

public class Yuk {

	private String isim;
	private double agirlik;
	private LocalDate kabulTarihi;
	
	// CONSTRUCTOR:
	public Yuk(String isim, double agirlik, LocalDate kabulTarihi) {
		super();
		this.isim = isim;
		this.agirlik = agirlik;
		this.kabulTarihi = kabulTarihi;
	}

	// GETTERS AND SETTERS:
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public double getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(double agirlik) {
		this.agirlik = agirlik;
	}

	public LocalDate getKabulTarihi() {
		return kabulTarihi;
	}

	public void setKabulTarihi(LocalDate kabulTarihi) {
		this.kabulTarihi = kabulTarihi;
	}

	// METHODS: --------
	@Override
	public String toString() {
		return "Yuk [isim=" + isim + ", agirlik=" + agirlik + ", kabulTarihi=" + kabulTarihi + "]";
	}
	
	
	
	
	
}
