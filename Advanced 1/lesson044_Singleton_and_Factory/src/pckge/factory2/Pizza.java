package pckge.factory2;

/*
 * 
 * Boy
 * fiyat�
 * malzemeleri
 * t�r (Ad)
 * Hamur tipi;
 * 
 * --------------
 * 2 tane alt  sınıf oluşturalım; biri Vejeteryan Pizza, ve
 * Etli Pizza. pizzaSec metodunda yaptığımız seçimlere göre
 * factory sınıfından bize bir pizza dönsün. 
 */
public abstract class Pizza {

	ETur tur;
	EBoyut boyut;
	EHamurTipi hamurTipi;
	double fiyat;
	String[] malzemleri;

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
