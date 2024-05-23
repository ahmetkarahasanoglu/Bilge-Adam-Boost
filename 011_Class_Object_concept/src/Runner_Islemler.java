import java.util.Scanner;

public class Runner_Islemler {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Araç fiyat giriniz: ");
		double fiyat = sc.nextDouble();
		System.out.print("Motor gücü giriniz (tam sayı): ");
		int guc = sc.nextInt();
		
		Islemler islem = new Islemler();
		System.out.println("ÖTV tutarı: " + islem.otv_hesapla(fiyat, guc));
		
		System.out.println("Toplama işlemi sonucu: " + islem.topla(3,4,5,6,7));

	}//main sonu

}//class sonu
