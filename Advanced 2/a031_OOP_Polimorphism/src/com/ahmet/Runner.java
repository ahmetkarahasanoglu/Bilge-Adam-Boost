package com.ahmet;

import com.ahmet.entity.Atlar;
import com.ahmet.entity.BuyukbasHayvanlar;
import com.ahmet.entity.KucukbasHayvanlar;
import com.ahmet.entity.KumesHayvanlari;
import com.ahmet.entity.ToprakAgasi;

public class Runner {

	public static void main(String[] args) {
/*
 * POLIMORPHISM - ÇOK BİÇİMLİLİK  - [Eski bir tabirle: hayvanın at gibi davranması, kedi gibi, köpek gibi, kuş gibi davranması]
 * (Kalıtım ile kullanılır.)
 * Bir toprak ağası olduğumuzu düşünelim. Büyükbaş hayvanlarımız, küçükbaş
 * hayvanlarımız ve kümes hayvanlarımız var. Ve marabalarımız var.
 * Marabalara şöyle mi demek mantıklı: "Büyükbaş hayvanların bakımı
 * yapılacak, küçükbaş hayvanların bakımı yapılacak, kümes hayvanlarının
 * bakımı yapılacak". Yoksa şöyle mi demek mantıklı: "Hayvanların bakımı 
 * yapılacak". İkincisi daha mantıklı. Polimorfizm buna benzer.
 */
		
		KumesHayvanlari kh = new KumesHayvanlari();
		kh.Besle();
		BuyukbasHayvanlar bh = new BuyukbasHayvanlar();
		bh.Besle();
		KucukbasHayvanlar kbh = new KucukbasHayvanlar();
		kbh.Besle();
		Atlar at = new Atlar();
		at.Besle();
		
		System.out.println("------------------------");
		
		ToprakAgasi t_aga = new ToprakAgasi();
		t_aga.Besle();  // "Hayvanlar beslendi."
		
		t_aga = new KumesHayvanlari();  // IMPORTANT !!!!!!!!!!!
		t_aga.Besle(); // "Kümes hayvanları beslendi."
		t_aga = new BuyukbasHayvanlar();
		t_aga.Besle(); // "Büyükbaş hayvanlar beslendi."
		t_aga = new KucukbasHayvanlar();
		t_aga.Besle(); // "Küçükbaş hayvanlar beslendi."
		t_aga = new Atlar();
		t_aga.Besle(); // "Atlar beslendi."
		
		
	}//main ends here

}//class ends here
