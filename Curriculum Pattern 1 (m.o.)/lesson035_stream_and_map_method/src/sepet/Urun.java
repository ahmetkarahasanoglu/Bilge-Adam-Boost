package sepet;

public class Urun {
	private String isim;
	private Double fiyat;
	
	// CONSTRUCTOR 1:
	public Urun() {
		
	}
	
	// CONSTRUCTOR 2:
	public Urun(String isim, Double fiyat) {		
		this.isim = isim;
		this.fiyat = fiyat;
	}	

	// GETTERS AND SETTERS:
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Double getFiyat() {
		return fiyat;
	}

	public void setFiyat(Double fiyat) {
		this.fiyat = fiyat;
	}
	
	
}
