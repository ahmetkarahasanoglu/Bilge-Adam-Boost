package com.ahmet;
import java.util.Scanner;

public class BasamakDegerleriniYazan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int userNumber = scanner.nextInt();
		int userNumberDupl = userNumber;
		
		int kaclarBasamagi = 1;
		while(userNumberDupl > 0) {
			int temp = userNumberDupl / 10;
			int basamakD = userNumberDupl - temp*10;			
			System.out.println(kaclarBasamagi + "'ler basamağı: " + basamakD);
			userNumberDupl = userNumberDupl / 10;
			kaclarBasamagi = kaclarBasamagi * 10;
		}
		scanner.close();
	}
}