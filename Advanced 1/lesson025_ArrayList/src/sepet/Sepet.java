package sepet;

import java.util.ArrayList;
import java.util.List;

public class Sepet {
	/*
	 * "Cips", "Kola", "Şeker", "Yağ", "Un", "Ekmek", "Çay", 
	 * "Yumurta", "Yoğurt", "Süt". 	
	 * - bu ürünleri enum'da tutalım.
	 * - Sepet class'ımızda bir ürün array'i olsun, string 
	 * 	 değerler tutsun ve  ürün enum'unu referans alsın.
	 * - Bir de sepetimiz olsun; String bir liste olsun.
	 * - Bir menümüz olsun:
	 * 1) Ürünleri listele -> 1-Cips 2-Kola ...... x-Süt 
	 * 2) Sepete ürün ekle (1'e bastığımızda sepete Cips'i eklesin vs)
	 * 3) Sepeti yazdır. 
	 */
	
	String[] urunler;
	List<String> sepet;
	
	public Sepet() {
		urunListesiOlustur();
		this.sepet = new ArrayList<String>();
	}
	
	
	
	public void menu() {
		int secim = 0;
		do {
			System.out.println("1-Ürünleri Listele");
			System.out.println("2-Sepete Ürün Ekle");
			System.out.println("3-Sepeti Görüntüle");
			secim = Utility.intDegerAlma("Lütfen bir işlem seçiniz: ");
			
			switch(secim) {
				case 1:
					urunleriListele();
					break;
				case 2:
					urunEkle();
					break;
				case 3:
					sepetiGoster();
					break;
				default:
					
			}			
				
		}while(secim != 0);
		
	}
	
	public void urunleriListele() {
		int i = 1;
		for(String urun : urunler) {
			System.out.println(i + "-" + urun);
			i++;
		}
	}
	
	public void urunListesiOlustur() {
		urunler = new String[EUrun.values().length];
		for(int i=0; i<EUrun.values().length; i++) {
			urunler[i] = EUrun.values()[i].toString();  // toString() yerine '.name' yazarsam da aynı sonuç geliyor.			
		}
	}
	
	public void urunEkle() {
		urunleriListele();
		int secim = Utility.intDegerAlma("Lütfen sepete ekleyeceğiniz ürünü seçiniz: ");
		sepet.add(urunler[secim-1]);
	}
	
	public void sepetiGoster() {
		for(String urun : sepet) {
			System.out.println(urun);
		}
	}
	

}