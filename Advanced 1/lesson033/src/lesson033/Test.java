package lesson033;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		List<Optional<Urun>> yeniUrunler = new ArrayList<>();
		UrunManager urunManager = new UrunManager();
		
//		for(int i=0; i<3; i++) {
//			Urun urun = urunManager.urunOlustur();
//			Optional<Urun> urun = urunManager.urunOlustur2();
//			urunManager.listeyeEkle(urun);
//			yeniUrunler.add(urun);
//		}

//		for(Urun urun : urunManager.urunler ) {
//			System.out.println(urun.getIsim());
//		}
//		for(Optional<Urun> urun : yeniUrunler) {
//			System.out.println(urun.get().getIsim()); // this is risky, may result in: NoSuchElementException. Below line is better.
//			// Or:
//			urun.ifPresent(u -> System.out.println(u));
//		}
		
		// Eğer ürün varsa fiyatını 2'yle çarpalım:
//		for(Optional<Urun> urun : yeniUrunler) {
//			urun.map((x) -> {
//				x.setFiyat(x.getFiyat() * 2);
//				return x;
//			}).ifPresent(System.out::println);		
//		}
		System.out.println("3)--------------------------------");
		
		Optional <String> kelime1 = Optional.ofNullable(null);
		Optional <String> kelime2 = Optional.ofNullable("yeni");
		Optional <String> kelime3 = Optional.ofNullable("merhaba dünya");
		
		kelime1.filter(x-> x.length()>5).ifPresent(System.out::println);
		kelime2.filter(x-> x.length()>5).ifPresent(System.out::println);
		kelime3.filter(x-> x.length()>5).ifPresent(System.out::println);		
		System.out.println("4)--------------------------------");
		
		System.out.println(kelime1.orElse("xxx"));
		System.out.println(kelime2.orElse("xxx"));
		System.out.println(kelime3.orElse("xxx"));		
		System.out.println("5)--------------------------------");
		
//		urunManager.sktGecmisUrunleriGoster();
//		urunManager.sktGecmemisUrunlereZamYap(30);
//		urunManager.listeyiGoster();
		
		Urun urun1 = new Urun("Yağ", 90d, 2020);
		Urun urun2 = new Urun("Şeker", 80d, 2021);
		Urun urun3 = new Urun("Un", 70d, 2027);
		urunManager.listeyeEkle2(urun1);
		urunManager.listeyeEkle2(urun2);
		urunManager.listeyeEkle2(urun3);
		
		urunManager.zamYap(urunManager.urunler);
//		urunManager.listeyiGoster();
		System.out.println("6)--------------------------------");
		urunManager.ortalamaFiyatGoster(urunManager.urunler);
		
		
		
		
	}//MAIN ENDS HERE -----

}//CLASS ENDS HERE -----
