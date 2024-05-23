package lesson033;
/*
 * isim, fiyat, int son kullanma tarihi 1970,2022.
 * UrunManager sınıfı oluşturalım. Bu sınıfta urunYarat
 * metodumuz olsun.
 *  - eğer ürün ismi yoksa ve fiyatı 0 ve 0'dan küçük ise
 *    null dönecek.
 *  - bu koşulların aksinde bir ürün oluşturup onu döneceğiz.
 */
public class Urun {
	private String isim;
	private double fiyat;
	private int skt;
	
	// CONSTRUCTOR:
	public Urun(String isim, Double fiyat, int skt) {		
		this.isim = isim;
		this.fiyat = fiyat;
		this.skt = skt;
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

	public int getSkt() {
		return skt;
	}

	public void setSkt(int skt) {
		this.skt = skt;
	}

	@Override
	public String toString() {
		return "Urun [isim=" + isim + ", fiyat=" + fiyat + ", skt=" + skt + "]";
	}
	
	
	
	

}
