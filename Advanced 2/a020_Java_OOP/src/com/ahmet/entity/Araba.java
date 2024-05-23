package com.ahmet.entity;

public class Araba {
	
	// PROPERTIES:
	public String renk;
	public String yakit;
	public int yolcuSayisi;
	public int maxHiz;
	public int kapiSayisi;
	public double lastikCapi;
	public double beygirGucu;
	public double uzunluk;
	public int vites = 1;
	public int direksiyonAcisi;
	public int hiz;
	public boolean motorCalisiyorMu = false;
	
	
	// ACTIONS:
	public void hizlan() {
		if(motorCalisiyorMu) {
			switch(vites) {
				case 1:
					if(hiz<100) hiz+=5;
					else System.out.println("Vites arttırın! Hızlanma komutu gerçekleştirilmedi.");
					break;
				case 2:
					if(hiz>=100 && hiz<180) hiz+=5;
					else System.out.println("Vites arttırın! Hızlanma komutu gerçekleştirilmedi.");
					break;
				case 3:
					if(hiz>=180 && hiz<220) hiz+=5;
					else System.out.println("Vites arttırın! Hızlanma komutu gerçekleştirilmedi.");
					break;
				case 4:
					if(hiz>=220 && hiz<300) hiz+=5;
					else System.out.println("Vites arttırın! Hızlanma komutu gerçekleştirilmedi.");
					break;
				case 5:
					if(hiz>=300) hiz+=5;					
					break;
			}
		}else {
			System.out.println("Önce motoru çalıştırın!");
		}
	}		
	
	public void motoruCalistir() {
		motorCalisiyorMu = true;
	}
	
	public void vitesArttir() {
		vites += 1;
	}
	
	
}
