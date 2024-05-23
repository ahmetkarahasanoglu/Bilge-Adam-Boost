package com.package1;

import java.util.Scanner;

public class Question29 {

	public static void main(String[] args) {
		
	/* Menu: Bir menü oluşturun. Input'tan ilgili numaraya basınca
	 * o sorunun çözümü yapılsın. Bir soru çözümü bittikten sonra tekrar
	 * başa dönsün menüye. Menü'de 0'a basınca çıkış yapsın.
	 * 
	 * 1) Dışarıdan bir kelime ve bir harf girilsin. Eğer kelimemizin
	 * için de o harf varsa kaç tane olduğunu ve index numaralarını yazdırın.
	 * Eğer harfi içermiyorsa bir çıktı versin: "Aradığınız harf yok" gibi.
	 * 
	 * 2) Dışarıdan bir kelime giriniz. Sonra değiştirmek istediğiniz harfi
	 * giriniz. Daha sonra hangi harfle değiştireceğinizi giriniz. Eğer kelimemiz içinde o harf
	 * varsa değiştirsin.
	 * 
	 * 3) Dışarıdan girilen bir kelimeyi ters çevirip yazdıralım. Palindrom
	 * olup olmadığını bulunuz (kek, iki, kabak gibi)
	 * 
	 * 4) Dışarıdan 5 adet kelime girelim. Her kelimede a, b veya c ile 
	 * başlayıp başlamadığımız kontrol etsin (a, b, c ile başlayanlar için 
	 * ayrı ayrı sayfa açıldığını düşünün elimizde). Her a bir sayfaya,
	 * her b bir sayfaya, her c bir sayfaya yazılacak gibi düşünelim. 
	 * Diğer harfle başlayanlar için ise ayrı bir sayfa düşünelim. Girilen
	 * 5 adet kelimeyi kontrol ettikten sonra elimizde kaç sayfa olduğunu 
	 * ekrana yazdıralım.
	 */

		Scanner sc = new Scanner(System.in);
		boolean willLoopRunAgain = true;
		
		do {
			System.out.println("-----------------------------------");
			System.out.println("Menüye hoşgeldiniz. Hangi soruyu çözmek istiyorsanız \n"
					+ "ilgili numaraya basınız: \n"
					+ "1) Bir kelimenin içinde bir harften kaç tane olduğunu bulma \n"
					+ "2) Bir kelime girişi ve değiştirmek istediğiniz harf... \n"
					+ "3) Palindrom olup olmadığını bulma \n"
					+ "4) Beş adet kelime girişi, ilk harfine göre sınıflandırıp, sınıf sayısını (~sayfa sayısını) yazdırma \n"
					+ "0) Çıkış");
			int choice = sc.nextInt();
			sc.nextLine(); // to fix the bug of java (nextLine after nextInt bug)
			switch(choice) {
			case 1:
				System.out.print("Enter a word: ");				
				String word = sc.nextLine();				
				System.out.print("Enter a letter: ");				
				String inputString = sc.nextLine();
				if(inputString.length() > 1) {
					System.out.println("Invalid letter entry! The letter must be 1 character.");
					break;
				}
				char letter = inputString.charAt(0);				
				if(word.contains(letter+"")) {
					int numberOfFindings = 0;
					String indexesOfOccurrences = "";					
					for(int i=0; i<word.length(); i++) {
						if(word.charAt(i) == letter) {
							numberOfFindings++;
							indexesOfOccurrences += i+ ", ";
						}
					}
					indexesOfOccurrences = indexesOfOccurrences.substring(0, indexesOfOccurrences.lastIndexOf(","));
					System.out.println("Number of findings of the letter in the word: " + numberOfFindings);
					System.out.println("Letter is found on these indexes of the word: " + indexesOfOccurrences);					
				}else {
					System.out.println("The word does NOT contain the letter you entered.");
				}
				break;
			case 2:
				System.out.println("Enter a word: ");
				String word2 = sc.nextLine();
				System.out.print("Enter the letter you want to replace: ");							
				String letter2 = sc.nextLine();
				if(letter2.length() > 1) {
					System.out.println("Invalid letter entry! The letter must be 1 character.");
					break;
				}
				if(word2.contains(letter2)) {
					System.out.print("Enter the new letter you want to replace with: ");
					String newLetter = sc.nextLine();
					if(newLetter.length() > 1) {
						System.out.println("Invalid letter entry! The letter must be 1 character.");
						break;					
					}
					word2 = word2.replace(letter2, newLetter);
					System.out.println("The new form of the word: " + word2);
				}else {
					System.out.println("The word does NOT contain the letter you entered.");
				}
				break;
			case 3:
				System.out.print("Enter the word that you want to check if it is palindrom: ");
				String word3 = sc.nextLine();
				String reverseWord = "";
				for(int i=word3.length()-1; i>=0; i--) {
					reverseWord += word3.charAt(i);					
				}
				if(word3.equals(reverseWord)) {
					System.out.println("It's palindrome.");
				}else {
					System.out.println("It's NOT palindrome.");
				}
				break;
			case 4:
				int aCount=0;
				int bCount=0;
				int cCount=0;
				int otherCount=0;
				int numberOfPages = 0;
				for(int i=0; i<5; i++) {
					System.out.print("Enter " + (i+1) + ". word: ");
					String wordInput = sc.nextLine();
					char firstCharacter = wordInput.charAt(0);					
					String firstCharacterAsStr = firstCharacter + "";
					firstCharacterAsStr = firstCharacterAsStr.toLowerCase();
					switch(firstCharacterAsStr) {
						case "a":
							aCount++;							
							break;
						case "b":
							bCount++;							
							break;
						case "c":
							cCount++;							
							break;
						default:
							otherCount++;							
					}
				}
				if(aCount > 0) {
					numberOfPages++;
				}
				if(bCount > 0) {
					numberOfPages++;
				}
				if(cCount > 0) {
					numberOfPages++;
				}
				if(otherCount > 0) {
					numberOfPages++;
				}
				System.out.println("Number of pages: " + numberOfPages);
				break;
			case 0:
				System.out.println("Çıkış yapıldı.");
				willLoopRunAgain = false;
//				System.exit(0); // this can be used too. Termination of the java program. (0) indicates successful termination.
			default:
				System.out.println("Invalid choice selection in the menu!");
			}
			
		}while(willLoopRunAgain);
		
		
		sc.close();
	}
}
