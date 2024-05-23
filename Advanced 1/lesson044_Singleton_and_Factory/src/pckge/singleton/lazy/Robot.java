package pckge.singleton.lazy;
/**
 * SINGLETON ÖRNEK. (lazy).
 * 1- Bir robotumuz var, çalış() metodu var.
 * 	  Çalış metodunda hashcode --> robot çalışıyor çıktısı verecek.
 * 2- Ev halkı sınıfımız olacak.
 * 3- Bu sınıfta robotCagir() metodu olacak, bu bize bir robot
 * 	  çağıracak.
 * 
 */
public class Robot {
	
	public static Robot instance = null;
	
	// CONSTRUCTOR:
	private Robot() {
	}
	
	// getInstance metodu:
	// Thread-safe yapmak için metodumuzu 'synchronized'
	// anahtar kelimesiyle senkronize metot
	// haline getirebiliriz. Veya başka bir yöntemle singleton
	// yapısı oluşturabiliriz.
	public synchronized static Robot getInstance() {
		if(instance == null) {
			instance = new Robot();
		}
		return instance;
	}
	
	public void calis() {
		System.out.println(instance + " robot çalışıyor.");
	}
}
