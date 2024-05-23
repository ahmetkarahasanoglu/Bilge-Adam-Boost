package com.ahmet;

import com.ahmet.controller.MusteriController;
import com.ahmet.repository.MusteriRepository;
import com.ahmet.repository.entity.Musteri;
import com.ahmet.utility.StaticValues;

/*
* - Controller: Garson gibi düşünebiliriz. Kullanıcıyla ilk iletişime geçen, ve kullanıcıya bilgiyi sunan kısım.
* - Service: İşin mutfağı. Gerekli malzemeleri alıp harmanlayıp bir ürün çıkartan kısım.
* - Repository: (Kiler gibi) Depomuzu yöneten kısım.
* - Utility: Herhangi bir sınıflandırmaya tabi değildir. Araçları içinde bulundurur.
 */
public class Runner {

	public static void main(String[] args) {
/*
 * --- SATIŞ OTOMASYON SİSTEMİ ---
 * 1- Ürün, Müşteri, Satış
 * 2- Depoya yeni ürün girilebilecek
 * 3- Ürünler satılabilecek
 * 4- Girilen ürün sayısı artacak, satılınca düşecek
 * 5- Müşteriler ve ürünlerin listesi olacak
 * 6- Satış yapılacak ve müşterilere yapılan satışlar listelenecek
 */
		
//		// Yeni bir müşteriyi kaydetmek:
//		Musteri musteri = new Musteri("Ahmet", "Kara", "İstanbul", "0555 666 77 88", "01-01-1990", 100);
//		MusteriRepository musteriRepository = new MusteriRepository();
//		musteriRepository.save(musteri);
//		
//		// Müşterileri getimek:
//		for(int i=0; i<musteriRepository.findAll().size(); i++) {
//			System.out.println("Müşteri......: " + musteriRepository.findAll().get(i).toString());
//		}
		
		MusteriController controller = new MusteriController();
		controller.MusteriKaydet();
		controller.MusteriKaydet();
		controller.MusteriListesiGöster();
		
	}//main ends here

}//class ends here
