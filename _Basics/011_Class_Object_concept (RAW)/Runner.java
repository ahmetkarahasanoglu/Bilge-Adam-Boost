
public class Runner {

	public static void main(String[] args) {
		
		//Creating objects from classes
		
		int number;
		number = 3;
		
		String text;
		text = "";
		
		Ogrenci ogrenci;
		ogrenci = new Ogrenci();
		
		
		ogrenci.ad = "Mehmet";
		ogrenci.okulNo = 255;
		ogrenci.okuduguBolumAdi = "Matematik";
		
		Ogrenci ogrenci2 = new Ogrenci();
		ogrenci2.ad = "Hasan";
		ogrenci2.soyad = "Güçlü";
		ogrenci2.dogumTarihi = 2001;
		
	/* NOTE: In order to have access to properties and methods of a class,
	 * we need to create and object from that class:
	 *   Ogrenci ogr = new Ogrenci();
	 *   ogr.ad = "Ahmet";
	 */
		System.out.println("Öğrenci nesnesi: " + ogrenci);
		System.out.println("Öğrenci adı: " + ogrenci.ad);
		System.out.println();
		
		
		Kedi vanKedisi = new Kedi();
		vanKedisi.eyeColor = "blue";
		vanKedisi.favoriteFood = "fish";
		vanKedisi.lifeTime = 10;
		System.out.println("VAN KEDİSİNİN ÖZELLİKLERİ: ");
		System.out.println("Van kedisinin göz rengi: " + vanKedisi.eyeColor);
		System.out.println("Van kedisinin en sevdiği yiyecek: " + vanKedisi.favoriteFood);
		System.out.println("Van kedisinin ömrü: " + vanKedisi.lifeTime);
		
		
		Kedi ankaraKedisi = new Kedi();
		ankaraKedisi.eyeColor = "brown";
		ankaraKedisi.favoriteFood = "chicken";
		ankaraKedisi.lifeTime = 15;
		System.out.println("ANKARA KEDİSİNİN ÖZELLİKLERİ: ");
		System.out.println("Ankara kedisinin göz rengi: " + ankaraKedisi.eyeColor);
		System.out.println("Ankara kedisinin en sevdiği yiyecek: " + ankaraKedisi.favoriteFood);
		System.out.println("Ankara kedisinin ömrü: " + ankaraKedisi.lifeTime);
		

	}//main ends here

}//class ends here
