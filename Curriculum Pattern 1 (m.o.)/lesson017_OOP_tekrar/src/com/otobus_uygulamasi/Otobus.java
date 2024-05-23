package com.otobus_uygulamasi;
// Şehir içi taşıma yapan otobüs.
public class Otobus {
	public int yolcuKapasitesi; // int için '0', String için 'null', boolean için 'false' olur başlangıç değerleri .
	public String soforIsmi;
	public double beygir;
	public int koltukSayisi;
	public String marka;
	public double yakitMiktari;
	public int kapiSayisi;	
	public boolean klimaVarMi;
	public int vites;
	public String renk;
	public boolean korukluMu;
	public int yolcuSayisi;
//	public Durak[] duraklar; // bunu yazmamıza gerek yok, çünkü duraklara zaten 'guzergah' özelliği üzerinden ulaşabiliyoruz.
	public Guzergah guzergah;
	
	
	// Metotlar:
	public void yolcuAl(int yolcular) {
		yolcuSayisi += yolcular;
	}	
	
}
