package com.muzikaletleri;

public class MuzikAleti {
	String menşei;
	String uretimTarihi;
	String ad;
	String tur;
	double boyut;	
	
	
	public MuzikAleti() {
	}
	
	public MuzikAleti(String menşeii, String uretimTarihii, String ad_, String turr, double boyutt) {
		menşei = menşeii;
		uretimTarihi = uretimTarihii;
		ad = ad_;
		tur = turr;
		boyut = boyutt;
	}
	
	
	public void cal() {
		System.out.println(ad + " ses çıkarıyor.");
	}
	
	public void bilgileriGoster() {
		System.out.println("Menşei..........: " + menşei);
		System.out.println("Üretim tarihi...: " + uretimTarihi);
		System.out.println("Ad..............: " + ad);
		System.out.println("Tür.............: " + tur);
		System.out.println("Boyut...........: " + boyut);
	}
}
