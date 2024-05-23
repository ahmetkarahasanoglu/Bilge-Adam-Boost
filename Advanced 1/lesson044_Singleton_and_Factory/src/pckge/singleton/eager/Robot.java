package pckge.singleton.eager;
/**
 * Eager tekniğiyle Singleton Pattern
 * 1- new'lemeyi instance'ı tanımladığımız yerde yaparız.
 * 	  Bunun tek dezavantajı, instance'ı new'lediğimiz için 
 *    (statik olarak), program ayağa kalktığında direkt bir
 *    nesne oluşacak.
 * 2- getInstance() metodunda null kontrolü yapmayız.
 * 
 */
public class Robot {
	
	public static Robot instance = new Robot(); // new'lemeyi burda yapıyoruz.
	
	// CONSTRUCTOR:
	private Robot() {
	}
	
	// getInstance metodu:
	public static Robot getInstance() {
		return instance;
	}
	
	public void calis() {
		System.out.println(instance + " robot çalışıyor.");
	}
}
