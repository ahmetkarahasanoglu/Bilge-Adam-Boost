package database;
/*
 * Mysql databse bir sınıf oluşturun.
 * Bu sınıfa bir interface yazacağız.
 * Ekleme, silme, getirme, ve güncelleme metotları olsun.
 * 
 * Bir Manager sınıfı yazalım, burda menümüz olsun
 * 1- Veri ekle
 * 2- veri sil
 * 3- veri güncelle
 * 4- Verileri getir.
 * 
 * seçim yapıp bu metotları çalıştıracağız.
 */
public class Test {
	
	
	public static void main(String[] args) {		
		
		menu();
		
		
	}//main sonu
	
	public static void menu() {	
		Manager manager; // Polimorfizm uyguluyoruz.	
		
		int secim = 0;
		do {
			System.out.println("1- Mysql");
			System.out.println("2- Oracle");
			secim = Utility.intDegerAlma("Lütfen hangi veritabanını kullanacağınızı seçiniz: ");
			switch(secim) {
				case 1:
					Mysql mysql = new Mysql();
					manager = new Manager(mysql);	
					mysql.login();
					manager.calistir();
					break;
				case 2:
					Oracle oracle = new Oracle();
					manager = new Manager(oracle);
					oracle.login();
					manager.calistir();
					break;
				default:
					System.out.println("Geçersiz seçim!");
			}
		}while(secim != 0);
		
	}
	
}//class sonu
