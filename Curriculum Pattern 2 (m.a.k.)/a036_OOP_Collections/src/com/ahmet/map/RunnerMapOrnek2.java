package com.ahmet.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerMapOrnek2 {

	public static void main(String[] args) {
/* (2'nci bir yöntem ile çözüldü).
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
		Map<EDepartman, List<String>> departmanlar = new HashMap();
		
		List muhasebePersonelleri = Arrays.asList("Ahmet", "Mehmet", "Cemal");
		List insanKaynaklariPersonelleri = Arrays.asList("Pelin", "Ece", "Pınar");
		List yazilimPersonelleri = Arrays.asList("Fikri", "Hasan", "Rıfkı");
		// key olarak enum kullanmak kullanışlıdır. Çünkü key'leri her zaman aklımızda tutamayabiliriz. Bu şekilde yapınca, kodu yazarken enum'lar içinden seçim yaparız; görsellik katmış oluruz: 
		departmanlar.put(EDepartman.MUHASEBE, muhasebePersonelleri);
		departmanlar.put(EDepartman.INSANKAYNAKLARI, insanKaynaklariPersonelleri);
		departmanlar.put(EDepartman.YAZILIM, yazilimPersonelleri);
		departmanlar.put(EDepartman.NETWORK, Arrays.asList("Dalyan", "Gürbüz", "Pehlivan"));
		
		departmanlar.forEach((k,v)->System.out.println(k + " -> " + v));
		

	}//main ends here

}//class ends here
