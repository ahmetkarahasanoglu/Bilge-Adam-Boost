package com.ahmet;

import com.ahmet.entity.Urun_NoDefaultConstructor;

public class RunnerUrun {

	public static void main(String[] args) {
		
		Urun_NoDefaultConstructor urun = new Urun_NoDefaultConstructor("Şeker", 24);

		// Ürün'ün kayıt edildiği düşünülsün.
		System.out.println("Ürün id......: " + urun.id);
		System.out.println("Ürün ad......: " + urun.ad);
		System.out.println("Ürün fiyat...: " + urun.fiyat);
		
	}//main ends here

}//class ends here
