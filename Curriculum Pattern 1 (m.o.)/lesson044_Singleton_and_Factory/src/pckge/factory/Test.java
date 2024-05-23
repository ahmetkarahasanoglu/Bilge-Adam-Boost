package pckge.factory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Lütfen loglama yapacağınız database ismini giriniz: ");
		String dbName = scanner.nextLine();
		
		// Standart nesne oluşturma:
		Postgre postgreLogger = new Postgre();
		Mongo mongoLogger = new Mongo();
		// Polimorfizm:
		ILogger postgreLogger2 = new Postgre(); // Polimorfizm
		ILogger mongoLogger2 = new Mongo();

		ILogger logger = DatabaseFactory.createDatabase(dbName);
		System.out.println(logger.getClass());
		
	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
