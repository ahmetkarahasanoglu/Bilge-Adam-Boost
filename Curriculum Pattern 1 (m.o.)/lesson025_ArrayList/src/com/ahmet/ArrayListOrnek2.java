package com.ahmet;

import java.util.ArrayList;
import java.util.Random;

/*
 * Soru: 1 tane tek sayılar 1 tane çift sayılar için bir liste
 * oluşturalım. Sonra 35 tane random sayıyı çift ise çiftlere
 * tek ise teklere atalım. En sonunda tekler ve çiftler
 * listesini yazdıralım.
 */
public class ArrayListOrnek2 {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> evensList = new ArrayList<Integer>();
		ArrayList<Integer> oddsList = new ArrayList<Integer>();
		
		for(int i=0; i<35; i++) {
			int randomNumber = new Random().nextInt(501);
			if(randomNumber%2 == 0) {
				evensList.add(randomNumber);
			}else {
				oddsList.add(randomNumber);
			}
		}
		
		int sequenceNum = 1;
		
		System.out.println("**** Evens List ****");
		for(Integer num: evensList) {
			System.out.println(sequenceNum + ") " + num);
			sequenceNum++;
		}
		
		System.out.println("**** Odds List ****");
		for(Integer num: oddsList) {
			System.out.println(sequenceNum + ") " + num);
			sequenceNum++;
		}
		

	}//main ends here

}//class ends here
