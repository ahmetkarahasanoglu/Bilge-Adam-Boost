package com.calisan;

public class InsanKaynaklari extends Personel implements IInsanKaynaklari {

	// CONSTRUCTOR 1:
	public InsanKaynaklari(String isim, String soyisim) {
		super(isim, soyisim);
		// TODO Auto-generated constructor stub
	}

	// CONSTRUCTOR 2:
	public InsanKaynaklari(String isim, String soyisim, double maas) {
		super(isim, soyisim, maas);
			
	}

	// METHODS: 
	@Override
	public double zamYap(Personel personel, double zamOrani) {
		double maas = personel.getMaas();
		double zamMiktari = maas * zamOrani / 100;
		maas += zamMiktari;
		if(personel instanceof Muhendis) {
//		if(personel.getClass().getSimpleName().equals("Muhendis")) {  // Üstteki satır yerine bu da kullanılabilir.
//		if(personel.getUnvan().contains("Mühendis")) {  // Bu satır da kullanılabilir aynı koşul için 
			maas += 250;
		}
		personel.setMaas(maas);
		personel.setUnvan(maas);
		return maas;		
	}

	@Override
	public void unvanBelirle() {
		// TODO Auto-generated method stub
		
	}
}
