package sepet;

public enum EUrun {

	CIPS(20), // constructor'da beklenen parametreyi yazdık (yoksa hata verir).
	KOLA(25),
	SEKER(30),
	YAG(90),
	UN(40),
	EKMEK(5),
	CAY(80),
	YUMURTA(20),
	YOGURT(30),
	SUT(52);
	
	double fiyat;
	
	// Enum'da Constructor kullanımı:
	EUrun(double fiyat) {
		this.fiyat = fiyat;
	}

	// GETTERS AND SETTERS:
	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	
	
}
