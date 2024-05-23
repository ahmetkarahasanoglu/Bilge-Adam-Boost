package database;

public class Oracle extends Database {

	@Override
	public void ekle() {
		System.out.println("Oracle veritabanına veri eklendi.");
		
	}

	@Override
	public void sil() {
		System.out.println("Oracle veritabanından veri silindi.");	
	}

	@Override
	public void guncelle() {
		System.out.println("Oracle veritabanında veri güncellendi.");
		
	}

	@Override
	public void verileriGetir() {
		System.out.println("Oracle veritabanından veriler getiriliyor.");
	}

	@Override
	public void login() {
		System.out.println("Oracle veritabanına bağlanıldı.");		
	}

}
