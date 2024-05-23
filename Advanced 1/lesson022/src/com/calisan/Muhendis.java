package com.calisan;

public class Muhendis extends Personel implements IHarcOdeme {

	
	// Constructor:
	public Muhendis(String isim, String soyisim) {
		super(isim, soyisim);
		this.setMaas(10_000); // min default salary for Muhendis
		setUnvan(this.getMaas());
	}
	
	// Constructor:
	public Muhendis(String isim, String soyisim, int maas) {
		super(isim, soyisim, maas);		
		setUnvan(maas);
	}
	
	// METHODS:			
	@Override
	public void setUnvan(double maas) {
		if(getMaas()<10_000) {
			setUnvan("stajyer");
		}else if(getMaas()>=10_000 && getMaas()<12_000) {
			setUnvan("mühendis");
		}else if(getMaas()>=12_000 && getMaas()<17_000) {
			setUnvan("kıdemli mühendis");
		}else if(getMaas() >= 17_000) {
			setUnvan("uzman mühendis");
		}
	}


	@Override
	public void harcOde() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
