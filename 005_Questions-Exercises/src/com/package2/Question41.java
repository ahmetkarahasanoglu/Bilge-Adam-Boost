package com.package2;

public class Question41 {

	public static void main(String[] args) {
		
	/* Soru: Çarpım tablosunu yazdırın. İki boyutlu array kullanın. 
	 * 1'ler için bir sütun, 2'ler için bir sütun...
	 * 10'lara kadar (10'lar dahil)
	 * 1x1=1 --> array'a at
	 * 1x2=2 --> array'a at.
	 */
		String[][] arr = new String[10][10]; 
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				arr[i][j] = (j+1) + "x" + (i+1) + "=" + (j+1)*(i+1);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
