package com.ahmet.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerMapOrnek {

	public static void main(String[] args) {
/*
 * Bir işyerinde çalışan kişiler aşağıdaki departmanlara göre 
 * dağıtılmıştır.
 * - Muhasebe
 * - InsanKaynaklari
 * - Yazilim
 * - Donanim
 * - Network
 * - Nakliye
 * - YardimciHizmetli
 * - Yonetim
 * çalışan personelleri bu birimlere göre dağıtın.
 * istenilen departmanda kişiler listelenerek ekrana yazdırılsın.
 */
		Map<String, List<String>> departmanlar = new HashMap(); // Each item of 'departmanlar' will have a String (as key) and a list (as value). As you can see, the value can be a list.
		List muhasebePersonelleri = Arrays.asList("Ahmet", "Mehmet", "Cemal");
		List insanKaynaklariPersonelleri = Arrays.asList("Pelin", "Ece", "Pınar");
		List yazilimPersonelleri = Arrays.asList("Fikri", "Hasan", "Rıfkı");
		
		departmanlar.put("muhasebePersonelleri", muhasebePersonelleri);
		departmanlar.put("insanKaynaklariPersonelleri", insanKaynaklariPersonelleri);
		departmanlar.put("yazilimPersonelleri", yazilimPersonelleri);
		
		System.out.println(departmanlar.get("yazilimPersonelleri").get(2));
		System.out.println(departmanlar.get("yazilimPersonelleri"));
		System.out.println(departmanlar);
		
	}//main end here

}//class ends here
