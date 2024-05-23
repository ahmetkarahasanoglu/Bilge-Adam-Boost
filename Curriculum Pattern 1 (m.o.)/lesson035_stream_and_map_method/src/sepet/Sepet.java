package sepet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * 1- Urun sınıfımızda isim ve fiyat değerlerini tutacağız,
 *    bunlar için gerekli getter & setter ve constructor 
 *    yapılarını kuracağız.
 * 2- Sepette EUrunler'den bir array'imiz olsun.
 *    - Bir de ürün listemiz olsun. Bir 'urunOlustur' metodu
 *      yapıp,
 *    - EUrun product arrayindeki enumların değerleri ile ürün
 *      listemizi dolduralım.
 * 3- Bir ürün fiyat map'imiz olsun. Bu map'i ürünler lsitesi 
 *    üzerinden oluşturalım. 
 * 4- urun ekle metodu ekleyelim listeden donup indexine göre 
 * secebilirz yada String olarak girebilirz. Burdaki mapimize 
 * dışarıdan bir urun ekleyeceğiz her seçişte bir tane 
 * ekleiyecek yani 1er 1 er atacak.
 * 5- 2 tane mapimiz var 1.map sepet sepet uzerinde bir urune 
 * denk geldiğimde bu urunun kaç adet oldugunu biliyorum aynı 
 * urun urun fiyat mapinde de tutuluyor aynı urun ismiylede 
 * diğier mapden fiyatı cekerim sonra adet*fiyattan bir fiyat 
 * degerim olur bunu mapdaki her bir eleman için yapacağız ve 
 * her bir elam için bize bir double fiyat doneek bu fiyatlarıda 
 * bir double listede toplayalım ve daha sonra bu double listedeki 
 * değerleri toplayalım buda bize sepetteki toplam fiyatı verecek
 */
public class Sepet {

	EUrun[] product = EUrun.values();
	List<Urun> urunler = new ArrayList<>(); // 'ürünler kataloğu' gibi düşünebiliriz burayı.
	Map<String, Double> urunFiyatMap = new HashMap<>(); // ürün adı - ürün fiyatı Map'i
	Map<String, Integer> sepet = new HashMap<>(); // ürün adı - ürün adedi Map'i
//	List<String> urunler2; // "Cips-20", "Kola-25".
	
	// CONSTRUCTOR:
	public Sepet() {
		urunOlustur();
		mapOlusturUrunFiyat();
	}
	
	public void urunOlustur() {		
//		for(int i=0; i<product.length; i++) {
//			Urun urun = new Urun();
//			urun.setFiyat(product[i].fiyat);
//			urun.setIsim(product[i].name()); // 'name' method brings the enum value as a string.
//			urunler.add(urun);
//		}
		//Or, with enhanced 'for' loop:
		for(EUrun eurun : product) {
			Urun urun = new Urun();
			urun.setFiyat(eurun.fiyat);
			urun.setIsim(eurun.name()); // 'name' method brings the enum value as a string.
			urunler.add(urun);
		}
	}
	
	public void urunOlustur2() {
//		List<EUrun> urunListesi = Arrays.asList(product);
//		urunListesi.stream().forEach(x -> urunler.add(new Urun(x.name(), x.fiyat)));
		Arrays.asList(product).stream().forEach(x -> urunler.add(new Urun(x.name(), x.fiyat)));
//		Arrays.stream(product).forEach(x -> urunler.add(new Urun(x.name(), x.fiyat)));
	}
	
	public void mapOlusturUrunFiyat() {
		urunFiyatMap = urunler.stream()
				.collect(Collectors.toMap(u -> u.getIsim(), u -> u.getFiyat()));
//		urunFiyatMap.forEach((k,v) -> System.out.println(k + " --> " + v));
		// *** Version 2:
//		urunler.stream().forEach(x -> urunFiyatMap.put(x.getIsim(), x.getFiyat()));
	}
	
	public void sepeteUrunEkle() {	
		// my code:
		for(int i=0; i<urunler.size(); i++) {
			System.out.println((i) + "- " + urunler.get(i).getIsim());
		}
		System.out.println("10- ÇIKIŞ");
		Scanner sc = new Scanner(System.in);
		int secim;
		int index;
		do {
			System.out.println("Eklemek istediğiniz ürünü seçiniz. Çıkış için 10 giriniz. ");
			secim = Integer.parseInt(sc.nextLine());			
			if(secim != 10) {
				Urun urun = urunler.get(secim);
				if(sepet.containsKey(urun.getIsim())) {
					sepet.put(urun.getIsim(), sepet.get(urun.getIsim()) + 1);
				}else {
					sepet.put(urun.getIsim(), 1);
				}
			}
		}while(secim != 10);	
		
		// --- Teacher's Code: ---
//		if(sepet.containsKey(urunIsmi)) {
//			sepet.put(urunIsmi,  sepet.get(urunIsmi) + 1);
//		}else {
//			sepet.put(urunIsmi, 1);
//		}
	}
	
	public void sepetToplami() {
		 double toplam = 0;
		 ArrayList<Double> herBirUrununToplamTutarlari = new ArrayList<>();

		    for (Map.Entry<String, Integer> entry : sepet.entrySet()) { // Ürün adı - ürün adedi Map'i
		        String urunIsmi = entry.getKey();
		        int adet = entry.getValue();

		        if (urunFiyatMap.containsKey(urunIsmi)) {				// Ürün adı - ürün fiyatı Map'i
		            double urunFiyat = urunFiyatMap.get(urunIsmi);
		            double urunToplamFiyat = adet * urunFiyat;		            
		            toplam += urunToplamFiyat;
		            herBirUrununToplamTutarlari.add(urunToplamFiyat);
		            System.out.println(urunIsmi + " --> Adet: " + adet + ", Fiyat: " + urunFiyat + ", Toplam Fiyat: " + urunToplamFiyat);
		        }
		    }
		    System.out.println("Toplam Sepet Fiyati: " + toplam);
		    Double toplamFromArrList = herBirUrununToplamTutarlari.stream().reduce(0.0, (total, collector) -> total + collector);
		    System.out.println("toplamFromArrList: " + toplamFromArrList);
	}
	
	public void sepetiGoster() {
		sepet.forEach((k,v) -> System.out.println(k + " --> " + v));
		sepetToplami();
	}
	
	public void urunleriListele() {
		urunFiyatMap.forEach((urun,fiyat) -> System.out.println(urun + " --> " + fiyat));
	}
	
	public void menu() {
		int kontrol = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("-----------");
			System.out.println("1-Ürün Listesi Göster");
			System.out.println("2-Ürün Ekle");
			System.out.println("3-Sepeti Göster");
			System.out.println("0-ÇIKIŞ");
			System.out.println("-----------");
			System.out.println("Lütfen Seçim Yapınız: ");
			kontrol = scanner.nextInt();
			
			switch (kontrol) {
			case 1:
				urunleriListele();
				break;
			case 2:
				sepeteUrunEkle();
				break;
			case 3:
				sepetiGoster();
				break;
			case 0:

				break;
			default:
				break;
			}
			
		}while(kontrol != 0);
	}
	
}
