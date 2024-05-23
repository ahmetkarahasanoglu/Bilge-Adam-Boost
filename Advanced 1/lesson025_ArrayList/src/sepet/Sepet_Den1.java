package sepet;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * "Cips", "Kola", "Şeker", "Yağ", "Un", "Ekmek", "Çay", 
 * "Yumurta", "Yoğurt", "Süt". 	
 * - bu ürünleri enum'da tutalım.
 * - Sepet class'ımızda bir ürün array'i olsun. Bu ürün array'i
 * de ürün enum'unu referans alsın.
 * - Bir de sepetimiz olsun; String bir liste olsun.
 * - Bir menümüz olsun:
 * 1) Ürünleri listele -> 1-Cips 2-Kola ...... x-Süt 
 * 2) Sepete ürün ekle (1'e bastığımızda sepete Cips'i eklesin vs)
 * 3) Sepeti yazdır. 
 */
public class Sepet_Den1 {
	
	
	static ArrayList<EUrun> urunler = new ArrayList<EUrun>();
	static ArrayList<String> sepet = new ArrayList<String>();
	
	
	public static void main(String[] args) {		
		
		for(EUrun urun : EUrun.values()) {
			urunler.add(urun);
		}
		
		islemler();
		
		
	}//MAIN ENDS HERE ------------
	
	public static void menu() {
		System.out.println("**** MENU ****");
		System.out.println("1) Ürünleri Listele");
		System.out.println("2) Sepete Ürün Ekle");
		System.out.println("3) Sepeti Yazdır");
	}
	
	public static int secimYap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seçim yapınız: ");
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
	
	public static void islemler() {
		int secim;
		do{
			menu();
			secim = secimYap();
			switch(secim) {
			case 1:
				urunleriListele();
				break;
			case 2:				
				sepeteUrunEkle();
				break;
			case 3:
				sepetiYazdir();
				break;
			case 0:
				System.out.println("Çıkış Yapılıyor");
				break;
			default:
				System.out.println("Geçersiz seçim!");
				
			}
		}while(secim != 0);		
	}
	
	public static void urunleriListele() {
		System.out.println("*** Ürünler Listesi (Katalog) ***");
		int sequenceNum = 1;
		for(EUrun urun : urunler) {
			System.out.println(sequenceNum + ") " + urun);
			sequenceNum++;
		}
	}
	
	public static void sepeteUrunEkle() {
		System.out.println("**** Sepete Ürün Ekleme ****");
		Scanner sc = new Scanner(System.in);			
		System.out.print("Sepete eklemek istediğiniz ürünün numarasını giriniz: ");		
		int num = Integer.parseInt(sc.nextLine());
		sepet.add(urunler.get(num-1).name());
	}
	
	public static void sepetiYazdir() {
		for(String urun : sepet) {
			System.out.println(urun);
		}
	}
	
	
}//CLASS ENDS HERE
