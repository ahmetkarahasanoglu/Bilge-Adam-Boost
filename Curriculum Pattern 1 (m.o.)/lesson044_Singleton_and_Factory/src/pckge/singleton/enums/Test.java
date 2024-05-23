package pckge.singleton.enums;

public class Test {

	public static void main(String[] args) {
		
		EvHalki anne = new EvHalki();
		EvHalki baba = new EvHalki();
		EvHalki cocuk = new EvHalki();
		
		Thread thread1 = new Thread(anne);
		Thread thread2 = new Thread(baba);
		Thread thread3 = new Thread(cocuk);
		
		thread1.run(); 
		thread2.run();
		thread3.run();
		


	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
