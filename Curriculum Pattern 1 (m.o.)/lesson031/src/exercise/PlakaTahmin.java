package exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Bu arrayden bir map oluşturan metot yazalım.
 * Key değerleri plaka değerleri olsun, value da
 * şehirler olsun.
 * 01,02 değil de 1,2 şeklinde yazalım plakaları.
 * 
 * oyun sayısını
 * hakkımız olsun () --> bir oyunda 3 kere tahminde bulunabiliriz.
 * 
 * menümüz olacak.
 * 
 * Şehir tahmin oyununa hoşgeldiniz.
 * Her oyun için 3 tahmin hakkınız bulunmaktadır.
 * 
 * 1-oyuna başla
 *   1.oyun (kaçıncı oyundaysak)
 *   3 tahmin hakkımız var (her defasında azalacak)
 * 
 * Random bir plaka üreteceğiz. Ve kullanıcıya soru
 * soracağız. Bu plaka hangi ile aittir; kullanıcıdan
 * gelen değere göre işlem yapacağız. Doğruysa "bildiniz"
 * yanlışsa "tekrar deneyin" çıktısını verip başa 
 * döneceğiz (toplamda 3 tahmin hakkımız bulunmaktadır).
 * Başarılı bildiğimiz zaman ve tahmin hakkımız kalmadığı
 * zaman ana menüye dönsün.
 * 
 * 2-Eski Tahminlerim=> 1'den fazla oyun oynayabilirim.
 * Her oyunun tahminlerini bir yerde tutacağım, sonra
 * burayı çağırdığım zaman her oyunun tahminleri ayrı 
 * ayrı yazılsın.
 * 
 * 3-ÇIKIŞ
 */
public class PlakaTahmin {
	String[] iller = { "Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın",
			"Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum",
			"Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun",
			"Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri",
			"Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin",
			"Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas",
			"Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray",
			"Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük",
			"Kilis", "Osmaniye", "Düzce" };
	
	Map<Integer, String> sehirMap = new LinkedHashMap<>();
	Map<Integer, List<String>> tahminler = new LinkedHashMap<>();
	
	public void mapOlustur(String[] arr) {		
		for(int i=0; i<iller.length; i++) {
			sehirMap.put(i+1, iller[i]);
		}		
	}
	
	public void yazdir(Map<Integer, String> map) {
		map.forEach((k,v) -> System.out.println(k + " --> " + v));
	}
	
		
}//CLASS ENDS HERE -----
