package pckge;

public class Calisan extends Thread { // pay att.

	String name;

	public Calisan(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() { // pay att. - overriding the 'run()' method of 'Thread'. When executed, this method runs asynchrously. 
		for(int i=0; i<10; i++) {
			System.out.println(name + " çalışıyor --> " + (i+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void calis() { // thread'li işlem değil.
		for(int i=0; i<10; i++) {
			System.out.println(name + " çalışıyor(calis metodu) --> " + (i+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	
}
