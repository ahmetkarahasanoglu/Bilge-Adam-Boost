package com.ahmet;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		Takim takim1 = new Takim("Ev sahibi");
		Takim takim2 = new Takim("Deplasman");
		List<Takim> takimlar = new ArrayList<>();
		takimlar.add(takim1);
		takimlar.add(takim2);
		
		Mac mac = new Mac(60000, takimlar);
//		Takim macaBaslayacakTakim = mac.yaziTura();
//		mac.oyna(macaBaslayacakTakim);
		mac.mac();
		

	}//MAIN ENDS HERE --------

}//CLASS ENDS HERE -------
