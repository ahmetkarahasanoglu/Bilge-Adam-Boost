package com.ahmet;

public class Methods7_practice_MtdOvrld {

	public static void main(String[] args) {
		
	/* int tipteki değerleri toplayıp sonuç üreten metotlar yazın.
	 * 
	 */
		System.out.println("Toplam: " + topla(5 ,9));
		System.out.println("Toplam: " + topla(7, 8, 9));
		int numArr[] = new int[] {10, 20, 30}; 
		System.out.println("Toplam: " + topla(numArr));
		

	}//main ends here
	
	// the easy and logical way to sum up a lot of numbers (is: using array):
	static int topla(int[] numbersArr) {
		int total = 0;
		for(int i=0; i< numbersArr.length; i++) {
			total += numbersArr[i];
		}
		return total;
	}
	
	static int topla(int s1, int s2) {
		return s1+s2;
	}
	static int topla(int s1, int s2, int s3) {
		return s1+s2+s3;
	}

}//class ends here
