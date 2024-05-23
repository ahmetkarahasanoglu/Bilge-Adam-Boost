package com.interfaceornek;

public class Test {

	public static void main(String[] args) {
		
		Arac arac = new Arac();
		arac.ilerle();
		arac.dur();
		
		System.out.println("---------");
		
		Arac arac1 = new Bisiklet();
		arac1.ilerle();
		arac1.dur();
		
		Arac arac2 = new Araba();
		arac2.ilerle();
		arac2.dur();
		
		Arac arac3 = new Ucak();
		arac3.ilerle();
		arac3.dur();
		
		System.out.println("------------------------");
		
//		Bisiklet bisiklet = new Bisiklet();
//		hareketEt(bisiklet);
		Arac arac4 = new Ucak();
		hareketEt(arac4);		  // Önemli
		
		IHareket hareket = new Bisiklet();
		hareketEt_2((Arac) hareket);
		
	}//main ends here
											  // Önemli
	public static void hareketEt(Arac arac) { // Polimorfizm
		arac.ilerle();
	}
	public static void hareketEt_2(IHareket arac) { // Polimorfizm  [IHareket -> Arac --> Bisiklet]
		arac.ilerle();
	}
	
	public static void hareketEt_Manuel(Arac arac) { // Polimorfizm kullanmadık burda. 
		if(arac instanceof Bisiklet) {
			System.out.println("Bisiklet hareket ediyor");
		}else if(arac instanceof Ucak) {
			System.out.println("Ucak hareket ediyor");
		}else if(arac instanceof Araba) {
			System.out.println("Araba hareket ediyor");
		}
		
	}

}//class ends here
