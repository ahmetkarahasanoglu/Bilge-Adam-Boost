package lesson033;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
/*
 * Skt tarihi geçmemiş ürünlere %30 zam yapalım. Bunları bir
 * sete atalım, sonra seti yazdıralım.
 * 
 * Ürünlerimizin fiyatlarının ortalamasını getiren stream
 * kodunu yazınız.
 */
public class UrunManager {
	
	List<Urun> urunler = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public Urun urunOlustur() {
		System.out.println("--- Yeni Ürün Oluşturma ---");
		System.out.println("Ürün adı giriniz: ");
		String urunAdi = scanner.nextLine();
		System.out.println("Ürün fiyatı giriniz: ");
		double fiyat = Double.parseDouble(scanner.nextLine());
		System.out.println("Ürün skt giriniz: ");
		int skt  = Integer.parseInt(scanner.nextLine());
		if(urunAdi.equals(null) || urunAdi.isBlank() || fiyat<=0) {
			return null;
		}else {
			Urun urun = new Urun(urunAdi, fiyat, skt);
			urun.setIsim(urunAdi);
			urun.setFiyat(fiyat);
			urun.setSkt(skt);
			return urun;
			// or:
//			return new Urun(isim, fiyat, skt);
		}
	}
	
	public Optional<Urun> urunOlustur2() { // by using 'Optional'
		System.out.println("--- Yeni Ürün Oluşturma ---");
		System.out.println("Ürün adı giriniz: ");
		String urunAdi = scanner.nextLine();
		System.out.println("Ürün fiyatı giriniz: ");
		double fiyat = Double.parseDouble(scanner.nextLine());
		System.out.println("Ürün skt giriniz: ");
		int skt  = Integer.parseInt(scanner.nextLine());		
		if(urunAdi.equals(null) || urunAdi.isBlank() || fiyat<=0) {
			return Optional.empty();  // or:  return Optional.ofNullable(null);
		}else {
			Urun urun = new Urun(urunAdi, fiyat, skt);
			urun.setIsim(urunAdi);
			urun.setFiyat(fiyat);
			urun.setSkt(skt);
			return Optional.of(urun);			
		}
	}
	
	public void listeyeEkle(Optional<Urun> urun) {
		if(urun.isPresent()) {
			urunler.add(urun.get());
		}		
	}
	
	public void listeyeEkle2(Urun urun) {
		Optional<Urun> optionalUrun = Optional.ofNullable(urun);
		if(optionalUrun.isPresent()) {
			urunler.add(optionalUrun.get());
		}				
	}
	
	public void listeyiGoster() {
		System.out.println("--- Listedeki Ürünler: ---");
		urunler.forEach(x -> System.out.println(x));
	}
	
	public void sktGecmisUrunleriGoster() {
		System.out.println("--- Son Kullanma Tarihi Geçmiş Ürünler: ---");
		urunler.stream()
				.filter(u -> u.getSkt()<2022)		
				.forEach(System.out::println); // IMPORTANT: 'forEach' doesn't return anything; filter returns something.
	}
	
	public void sktGecmemisUrunlereZamYap(int yuzdeKacZam) {
		urunler.stream()
				.filter(u -> u.getSkt()<2022)
				.forEach(x -> x.setFiyat(x.getFiyat()*(100 + yuzdeKacZam)/100));				
	}
	
	public void zamYap(List<Urun> urunler) {
		Set<Urun> zamliUrunler = urunler.stream().filter(x -> x.getSkt()>2022).map(y ->{
			y.setFiyat(y.getFiyat()*1.3);
			return y;
		}).collect(Collectors.toSet());	
		// using 'return' keyword inside 'filter':
		Set<Urun> zamliUrunler2 = urunler.stream().filter(x ->
		{
			if(x.getSkt() > 2022) {
				x.setFiyat(x.getFiyat()*1.3);
				return true;		// filter method expects a true/false in the return.
			}
			return false;
		}).collect(Collectors.toSet());
		
		zamliUrunler.forEach(System.out::println);
	}
	
	public void ortalamaFiyatGoster(List<Urun> urunler) {
//		double ortalama = urunler.stream().mapToDouble(x -> x.getFiyat()).average().orElse(0.0);
//		System.out.println("Ortalama fiyat: " + ortalama);
		// Teacher's code:
		double ort = urunler.stream().collect(Collectors.averagingDouble(x -> x.getFiyat()));
		System.out.println("Ortalama fiyat: " + ort);
	}
}
