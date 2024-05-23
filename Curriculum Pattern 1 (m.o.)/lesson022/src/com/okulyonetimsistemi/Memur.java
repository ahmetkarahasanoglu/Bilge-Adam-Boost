package com.okulyonetimsistemi;

public class Memur extends Calisan implements IOgrenciIsleri {

	
	// CONSTRUCTOR 1:
	public Memur(String isim, String soyisim) {
		super(isim, soyisim);		
	}
	
	// CONSTRUCTOR 2:
	public Memur(String isim, String soyisim, double maas, int calismaSaati) {
		super(isim, soyisim, maas, calismaSaati);
	}

	
	// --- METHODS: ---
	@Override
	public Ogrenci ogrenciKaydi() {
		String isim = OysUtility.stringDegerAlma("Öğrencinin ismini giriniz: ");
		String soyisim = OysUtility.stringDegerAlma("Öğrencinin soyismini giriniz: "); 
		Ogrenci ogrenci = new Ogrenci (isim, soyisim);
		return ogrenci;
	}

	@Override
	public boolean ogrenciKaydiSil(String ogrenciNo) {
		for(Ogrenci ogrenci : Okul.ogrenciListesi) {
			if(ogrenci.getOkulNo().equals(ogrenciNo)) {
				Okul.ogrenciListesi.remove(ogrenci);
				return true;
			}
		}
		return false;
	}

	@Override
	public void bilgilendirmeYap(Ogrenci ogrenci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean dersKaydiOnayla(Ders ders, Ogrenci ogrenci) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public void menu() {
		
		int secim = -1;
		do {
			super.menu();
			System.out.println("*** Memur İşlemleri ***");
			System.out.println("1- Öğrenci kaydı yap");
			System.out.println("2- Öğrenci kaydı sil");
			System.out.println("3- Bilgilendirme yap");
			System.out.println("4- Ders kaydı onayla");
			System.out.println("5- Öğretmenler listesi");
			System.out.println("6- Öğrenciler listesi");
			secim = OysUtility.intDegerAlma("Lütfen bir secim yapınız: ");
			islemler(secim);
			
		}while(secim != 0);
		
	}
	
	
	
	@Override
	public void ogrencileriListele() {
//		for(int i=0; i<Okul.ogrenciListesi.size(); i++) {
//			System.out.println(Okul.ogrenciListesi.get(i).getIsim());
//		}
		for(Ogrenci ogrenci : Okul.ogrenciListesi) {
			System.out.println(ogrenci.toString());
		}
		
	}
	
	public void islemler(int secim) {
		switch(secim) {
			case 1:
				Ogrenci ogrenci = ogrenciKaydi();
				Okul.ogrenciListesi.add(ogrenci);
				System.out.println(ogrenci.getIsim() + " adlı öğrenci başarılı bir şekilde kaydedilmiştir.");
				break;
			case 2:
				String ogrenciNo = OysUtility.stringDegerAlma("Silmek istediğiniz öğrencinin No'sunu giriniz: ");
				ogrenciKaydiSil(ogrenciNo);
				break;
			case 3:
	//				bilgilendirmeYap(Ogrenci ogrenci)
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				ogrencileriListele();
				break;
			default:
			
		}
		
	}

	

	
	
	
		
	
}
