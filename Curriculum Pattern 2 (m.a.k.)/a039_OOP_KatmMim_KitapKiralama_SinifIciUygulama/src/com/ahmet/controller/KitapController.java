package com.ahmet.controller;

import java.util.List;
import java.util.Scanner;

import com.ahmet.repository.entity.Kitap;
import com.ahmet.service.KitapService;

public class KitapController {

	private static Scanner sc;
	private final KitapService kitapService;
	
	
	private KitapController() {  // constructor'ı private yaptık ki, Runner sınıfında new'lenemesin (yeni nesne oluşturulamasın). Böylelikle burdaki 'save()' 'update()' vs. metotlarımıza dışarıdan erişilemesin. Bu sınıfa sadece 'public static' olan run() metodu ile erişilebilsin.
		super();
		this.kitapService = new KitapService(); // KitapController'dan bir nesne oluşturulduğunda KitapSevice'den de oluşturulsun dedik. (Aşağıda 'run()' metodunda KitapController'dan nesne oluşturuyoruz.)
	}
	
	public void save() {
		sc = new Scanner(System.in);
		System.out.print("Lütfen kitap adı giriniz: ");
		String kitapAdi = sc.nextLine();
		System.out.print("Lütfen kitap sayfa sayısı giriniz: ");
		int sayfaSayisi = sc.nextInt();
		sc.nextLine(); // dummy
		System.out.print("Lütfen yayınevi giriniz: ");
		String yayinevi = sc.nextLine();		
		kitapService.save(kitapAdi, sayfaSayisi, yayinevi);
	}
	
	public void findAll1() { // Olabilecek En Hantal Kullanım:
		for(int i=0; i<kitapService.findAll().size(); i++) {
			System.out.println("Kitabın Adı................: " + kitapService.findAll().get(i).getAd());
			System.out.println("Kitabın Sayfa Sayısı.......: " + kitapService.findAll().get(i).getSayfaSayisi());
			System.out.println("Kitabın Yayınevinin Adı....: " + kitapService.findAll().get(i).getYayinEvi());
		}
	}
	
	public void findAll2() {
		List<Kitap> liste = kitapService.findAll();
		for(int i=0; i<liste.size(); i++) {
			System.out.println("Kitabın Adı................: " + liste.get(i).getAd());
			System.out.println("Kitabın Sayfa Sayısı.......: " + liste.get(i).getSayfaSayisi());
			System.out.println("Kitabın Yayınevinin Adı....: " + liste.get(i).getYayinEvi());
		}
	}
	
	public void findAll3() {
		for(Kitap kitap : kitapService.findAll()) {
			System.out.println("Kitabın Adı................: " + kitap.getAd());
			System.out.println("Kitabın Sayfa Sayısı.......: " + kitap.getSayfaSayisi());
			System.out.println("Kitabın Yayınevinin Adı....: " + kitap.getYayinEvi());
		}
	}
	
	public void findAll4() {
		kitapService.findAll().forEach(k->{
			System.out.println("Kitabın Adı................: " + k.getAd());
			System.out.println("Kitabın Sayfa Sayısı.......: " + k.getSayfaSayisi());
			System.out.println("Kitabın Yayınevinin Adı....: " + k.getYayinEvi());
		});
	}
	
	public static void run() {	
		KitapController kitapController = new KitapController();
		int secim;
		sc = new Scanner(System.in);
		do {
			System.out.println("1- Kitap Ekle");
			System.out.println("2- Kitapları Listele");
			System.out.println("3- Kitap Bul");
			System.out.println("0- ÇIKIŞ");	
			System.out.print("Lütfen seçim yapınız: ");			
			secim = sc.nextInt();
			switch(secim) {
				case 1: kitapController.save();
					break;
				case 2: kitapController.findAll4();
					break;
				case 3: 
					
					break;
				case 0:
					
					break;
				default:
								
			}
		}while(secim != 0);
		
	}
}
