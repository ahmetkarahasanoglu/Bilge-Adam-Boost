package pckge.singleton;
/**
 * SINGLETON PATTERN:
 * (burda 'lazy initializer' tekniğiyle singleton pattern yaptık)
 * Tekil nesnesinin olmasını istediğimiz sınıfı tanımlarken:
 * 1- constructor -> private olmalı.
 * 2- sınıf içinde kendi referansında static bir değişken olmalı ('instance').
 * 3- static bir getInstance() metodu olmalı.
 * 4- metot içinde değişkenimizin null kontrolü yapılır. Eğer
 *    null ise değişkenimizi new'leriz, null değilse değişkeni
 *    return ederiz.
 */
public class MyPostgreConnection {
	
	private static MyPostgreConnection instance = null;
	
	// CONSTRUCTOR:
	private MyPostgreConnection() {  // pay att: 'private'
	}
	
	// method to call the single instance:
	public static MyPostgreConnection getINSTANCE() { // pay att: 'static'
		if(instance == null) {
			instance = new MyPostgreConnection();
		}
			return instance;
	}
	
}
