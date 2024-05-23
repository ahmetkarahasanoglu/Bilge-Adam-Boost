package com.abstractornek;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("---------");
		
		Arac arac1 = new Bisiklet();
		arac1.ilerle();
		arac1.dur();
		
		Arac arac2 = new Araba();
		arac2.hiz = 100;
		arac2.ilerle();
		arac2.dur();
		
		Arac arac3 = new Ucak();
		arac3.hiz = 20;
		arac3.ilerle();
		arac3.dur();
		
		System.out.println("------------------------");
		
		arac2.hiziGoster();
		arac3.hiziGoster();

		
	}//main ends here
											  
	public static void hareketEt(Arac arac) { 
		arac.ilerle();
	}
	public static void hareketEt_2(Arac arac) { 
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
