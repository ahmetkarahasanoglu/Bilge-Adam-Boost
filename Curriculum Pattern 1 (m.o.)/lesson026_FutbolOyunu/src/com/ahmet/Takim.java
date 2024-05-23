package com.ahmet;

import java.util.ArrayList;

import com.teacherscode.ITakim;

public class Takim implements ITakim {
	
	private String isim;	
	private Kaleci kaleci;
	private ArrayList<AktifFutbolcu> futbolcular;  // Önemli !!! : sınıfı 'AktifFutbolcu' yaptık, 'Futbolcu' yapmadık. Çünkü kullanacağımız pas vermeyle ilgili metotlar AktifFutbolcu sınıfında tanımlı. Bu satırda sınıfı 'Futbolcu' yazarsak Test sınıfında oluşturacağımız futbolcular pas vermeyle ilgili metotları kullanamıyorlar. Üst sınıflar alt sınıflardaki metotlara erişemezler, ancak alt sınıflar üst sınıflardaki metotlara erişebilirler.   
	
	
	// CONSTRUCTOR:
	public Takim(String isim) {
		this.futbolcular = new ArrayList<>();
		this.isim = isim;
		this.kaleci = new Kaleci("kaleci", 1);		
		defansOlustur();
		ortaSahaOlustur();
		forvetOlustur();
	}

	
	// GETTERS AND SETTERS:
	public String getIsim() {
		return isim;
	}

	public ArrayList<AktifFutbolcu> getFutbolcular() {
		return futbolcular;
	}

	public Kaleci getKaleci() {
		return kaleci;
	}
	

	// METHODS: --------
	@Override
	public String toString() {
		return "Takim [isim=" + isim + ", kaleci=" + kaleci + ", futbolcular=" + futbolcular + "]";
	}
	
	
	@Override
	public void defansOlustur() {
		for(int i=0; i<4; i++) {
			DefansOyuncusu defansOyuncusu = new DefansOyuncusu("defans" + (i+1), (i+2));
			futbolcular.add(defansOyuncusu);
		}		
	}

	@Override
	public void ortaSahaOlustur() {
		for(int i=0; i<4; i++) {
			OrtaSahaOyuncusu ortaSahaOyuncusu = new OrtaSahaOyuncusu("ortasaha" + (i+1), (i+6));
			futbolcular.add(ortaSahaOyuncusu);
		}		
	}

	@Override
	public void forvetOlustur() {
		for(int i=0; i<2; i++) {
			ForvetOyuncusu forvetOyuncusu = new ForvetOyuncusu("forvet" + (i+1), (i+10));
			futbolcular.add(forvetOyuncusu);
		}
	}	
	
	
	
}
