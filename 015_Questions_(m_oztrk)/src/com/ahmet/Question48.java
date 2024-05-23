package com.ahmet;

public class Question48 {

	public static void main(String[] args) {
		
//Dizideki elemanlar arasındaki mutlak farkın en küçük olduğu 
// değeri bulunuz.
// int[] array = { 1, 5, -4, 3 };		
		
		int[] array = { 1, 5, -4, 3 };	
		int smallestDifference = findSmallestDifference(array);
		System.out.print("The smallest difference: " + smallestDifference);
		

	}//main ends here

	public static int findSmallestDifference(int[] array) {
		int[] differences = new int[12];
		int indexDifferences = 0;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length; j++) {
				if(i != j) {
					int subtraction = Math.abs(array[i] - array[j]);
					differences[indexDifferences] = subtraction;
					indexDifferences++;
				}				
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<differences.length; i++) {
			if(differences[i] < min) {
				min = differences[i];
			}
		}	
		return min;
	}

}//class ends here
