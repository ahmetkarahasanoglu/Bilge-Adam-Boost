package com.calisan;

public class OfisCalisani extends Personel {

	
	// Constructor:
	public OfisCalisani(String isim, String soyisim) {
		super(isim, soyisim);		
		this.setMaas(8_000); // min default salary for OfisCalisani
		setUnvan(this.getMaas());		
	}
	// Constructor: 
	public OfisCalisani(String isim, String soyisim, double maas) {
		super(isim, soyisim, maas);
		setUnvan(maas);
	}
	
	// METHODS:	
	@Override
	public void setUnvan(double maas) {
		if(this.getMaas()<8_000) {
			setUnvan("stajyer");
		}else if(this.getMaas()>=8_000 && this.getMaas()<12_000) {
			setUnvan("çalışan");
		}else if(this.getMaas()>=12_000) {
			setUnvan("kıdemli çalışan");
		}
	}

}
