
public class Islemler {
	/*
	 * BİR SINIF İÇERİSİNE:	 * 
	 *  - Değişken
	 *  - Method
	 *  - Sınıf
	 *  
	 *  yazılabilir.
	 */
	public int topla(int... sayilar) {
		int toplam = 0;
		for(int i=0; i<sayilar.length; i++) {
			toplam +=  sayilar[i];
		}
		return toplam;
	}
	
	/**(burası açıklama bırakma kısmıdır. Metodun bir satır üzerindeyken
	 *  '/**' yazıp enter'a basarak oluşturulur.)
	 *   
	 * Bu metod, bir aracın fiyatını ve motor gücünü alarak, aracın ötv
	 * miktarını verir.
	 * @param fiyat Araç Fiyatı
	 * @param motorGucu Motor Gücü
	 * @return double tipinde ötv tutarı.
	 */
	public double otv_hesapla(double fiyat, int motorGucu) {
		double result = 0;
		if(motorGucu < 80) {
			result = fiyat * 1.4;
		}else if(motorGucu < 100) {
			result = fiyat * 1.6;
		}else {
			result = fiyat * 2;
		}
		return result;
	}
	
	
}
