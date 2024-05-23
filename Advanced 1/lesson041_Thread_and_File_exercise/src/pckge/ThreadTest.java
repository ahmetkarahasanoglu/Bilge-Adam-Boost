package pckge;

public class ThreadTest {

	public static void main(String[] args) {
		
		Calisan calisan1 = new Calisan("Mustafa");
		Calisan calisan2 = new Calisan("Ece");
		
		calisan1.start(); // invokes the 'run()' method of calisan
		calisan2.start(); // bunlar thread işlemi. thread'li olmasaydı, sırayla çalışırlardı, önce biri başlar biterdi, sonra diğeri başlardı. Bu şekilde olunca asenkron çalışıyorlar.
		
		calisan1.calis(); // thread'li işlem değil bunlar.
		calisan2.calis();

	}//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----
