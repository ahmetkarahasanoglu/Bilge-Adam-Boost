package pckge;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 * 1- Bir yük yeri seçme metodumuz olsun.
 * Bu metot limandaki yükler arasından bir yer belirlesin kendine
 * Eğer sınır dışı ise hatayı yakalayalım ve gösterelim.
 * 
 * 2- Kendi exception sınıfmızı yaratalım  () LimanAppException 
 * daha sonra seçtiğimiz indexdeki yer null değilse hata 
 * fırlatacagız "seçtiğiniz yer dolu".
 * 
 * 3- agırlık belirle()==> limanımız 100 kilo altı yukleri kabul etmiyor 
 * yukumuz bu kurala uymuyorsa bir exception fırlatalım.
 * 
 * 4- limanımız cuma gunleri kabul yapmıyor bunun için metot yazacagız
 * kabultarhihikontrol==> 
 * cuma gunu olup olmadıgını kontrol edip bir exception fırlatacagız.
 * 
 * 5- yükolustur metodunu yazalım bir yuk olusturken asagıdaki kontrolleri yapalım 
 * kontrollerden geçiyorsa yukumuzu ekleyelim.
 */

public class Uygulama {
	
	Liman liman;
	Scanner scanner = new Scanner(System.in);
		
	
	public Uygulama() {
		this.liman = new Liman();
	}
	
	public static void main(String[] args) {
		Uygulama uygulama = new Uygulama();	
//		uygulama.yukYeriSec();
		
		// --- 2. Yöntem: Metot tanımlamasında (yukYeriSec2())'de 'throw' kullanıp, try-catch'i burda main metodunda kullanmak:
//		try {
//			int yukYeriIndex = uygulama.yukYeriSec2();	
//			double agirlik = uygulama.kantar();
//			LocalDate kabulTarihi = uygulama.kabulTarihiKontrol();						
//		}catch(Exception e) {
//			System.out.println(e.toString());
//		}
		
		uygulama.yukOlustur(); // yukaridaki try-catch'i kullanmayalım, hata yakalamayı bu 'yukOlustur()' metodunun tanımlandığı yerde yapalım.
		
	}//MAIN ENDS HERE -------
	
//	public void yukYeriSec() {
//		System.out.print("Yük yeri giriniz: ");		
//		try {
//			int index = scanner.nextInt();
//			Yuk yuk = liman.getYukler()[index];
//		}catch(Exception e) {
//			System.out.println("Hata yakalandı: " + e.toString());
//			System.out.println("yakalandıktan sonraki satır");
//		}
//	}
	
	public int yukYeriSec2() {
		liman.getYukler()[0] = new Yuk("1", 100, LocalDate.now()); // başlangıç durumunda 0'ıncı indeks'te halihazırda bir yük olsun dedik.		
		System.out.print("Lütfen bir yük yeri seçiniz: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // dummy
		if(index < 0 || index>= liman.getYukler().length) {
			throw new LimanAppException(ErrorType.SINIRLAR_DISINDA, "Lütfen 0 ile " + liman.getYukler().length + " arasında bir seçim yapınız.");		
		}else if(liman.getYukler()[index] != null) {
			throw new LimanAppException(ErrorType.DOLU_YER_SECIMI);
		}
		return index;
	}
	
	public double kantar() {		
		System.out.print("Yükün ağırlığını giriniz: ");
		double agirlik = scanner.nextDouble();	
		scanner.nextLine(); // dummy
		if(agirlik < 100) {
			throw new LimanAppException(ErrorType.YETERSIZ_AGIRLIK);
		}
		return agirlik;
	}
	
	public LocalDate kabulTarihiKontrol() {
		System.out.print("Yükün kabul tarihini giriniz(yyyy-mm-dd): ");
		LocalDate kabulTarihi = LocalDate.parse(scanner.nextLine());
		if(kabulTarihi.isBefore(LocalDate.now())) {
			throw new LimanAppException(ErrorType.GECERSIZ_KABUL_TARIHI);
		}
		if(kabulTarihi.getDayOfWeek().equals(DayOfWeek.FRIDAY)) { 
			throw new LimanAppException(ErrorType.MESAI_GUNLERI_DISI);
		}
		return kabulTarihi;
	}
	
	public void yukOlustur() {
		Yuk yuk = null;
		int yukYeriIndex = 0;
		try {
			yukYeriIndex = yukYeriSec2();
			LocalDate date = kabulTarihiKontrol();
			double agirlik = kantar();
			System.out.println("Lütfen yükünüzün ismini giriniz: ");
			String isim = scanner.nextLine();
			yuk = new Yuk(isim, agirlik, date);
			liman.getYukler()[yukYeriIndex] = yuk;
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			if(yuk == null) {
				System.out.println("Yükünüz kabul olmamıştır.");
			}else {
				System.out.println("Yükünüz kabul olmuştur; " + yukYeriIndex + " nolu yere yerleştirilmiştir.");
			}
		}
	}
	
}//CLASS ENDS HERE ------
