package database;

import java.util.Scanner;

public class Manager {
	
//	Mysql mysql;
//	Oracle oracle;
//	IDatabase database;
	Database database;
	
//	public Manager() {
//		this.mysql = new Mysql();
//		this.oracle = new Oracle();
//	}
	
//	public Manager(IDatabase database) { // Polimorfizm. ('implements' yoluyla polimorfizm) - bu metoda gönderdiğimiz parametre Mysql veya Oracle sınıfından olabilir.
//		this.database = database;
//	}
	public Manager(Database database) {  // Polimorfizm. ('extends' the abstract class  yoluyla polimorfizm)
	this.database = database;
}
	
	
	public void menu() {		
		System.out.println("1- Veri Ekle");
		System.out.println("2- Veri Sil");
		System.out.println("3- Veri Güncelle");
		System.out.println("4- Verileri getir");
		System.out.println("0- Çıkış");
	}
	
	public void calistir() {
		int secim;		
		do {
			menu();			
			secim = Utility.intDegerAlma("Lütfen bir seçim yapın: ");
			switch(secim) {
				case 1:
					database.ekle();
					break;
				case 2:
					database.sil();
					break;
				case 3:
					database.guncelle();
					break;
				case 4:
					database.verileriGetir();
					break;
				case 0:
					System.out.println("ÇIKIŞ YAPILIYOR.");
					break;
				default:
					System.out.println("Geçersiz seçim!");
			}	
		}while(secim != 0);
			
		
	}
	
}
