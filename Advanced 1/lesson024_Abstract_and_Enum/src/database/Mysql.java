package database;

import java.util.ArrayList;

public class Mysql extends Database {
	
	
	@Override
	public void ekle() {
		System.out.println("Mysql veritabanına veri eklendi.");
		
	}

	@Override
	public void sil() {
		System.out.println("Mysql veritabanından veri silindi.");	
	}

	@Override
	public void guncelle() {
		System.out.println("Mysql veritabanında veri güncellendi.");
		
	}

	@Override
	public void verileriGetir() {
		System.out.println("Mysql veritabanından veriler getiriliyor.");
	}

	@Override
	public void login() {
		System.out.println("Mysql veritabanına bağlanıldı.");
		
	}
	
	

}
