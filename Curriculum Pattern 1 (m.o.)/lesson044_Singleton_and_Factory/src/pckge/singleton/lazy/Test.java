package pckge.singleton.lazy;

public class Test {

	public static void main(String[] args) {
		
		EvHalki anne = new EvHalki();
		EvHalki baba = new EvHalki();
		EvHalki cocuk = new EvHalki();
		
		Thread thread1 = new Thread(anne);
		Thread thread2 = new Thread(baba);
		Thread thread3 = new Thread(cocuk);
		
		
		/**
		 * thread kullanmak (lazy initializer ile) risklidir, 
		 * uygun değildir. lazy initializer ile
		 * oluşturduğumuz singleton yapımızda, 
		 * instance'ı aynı anda 'null' gören thread'ler yeni 
		 * farklı nesne üretebilir (istenmeyen bir şey).
		 */
		thread1.run(); 
		thread2.run();
		thread3.run();
		


	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
