package com.package3;

public class Question43_methods {

	public static void main(String[] args) {
		
	/* Bir metot yazalım. Bu metot dizi içindeki tek elemanları alıp başka
	 * bir diziye atsın ve o diziyi yazdırsın.
	 */
		int[][] matrix = { { 56, 23, 678, 231, 5 }, { 234, 21, 78, 26, 6 },
				{ 654, 33, 32, 67, 2}, { 189, 35, 56, 89, 8 }
		};
		
//		int numberOfOdds = 0;
//		
//		for(int i=0; i<matrix.length; i++) { // this double 'for' block is for finding the number of odds (the 'counterOfOdds'), and we will use it to create the 'oddNumbers[]' array below (for the length of it).
//			for(int j=0; j<matrix[i].length; j++) {
//				if(matrix[i][j] % 2 == 1) {
//					numberOfOdds++;
//				}
//			}
//		}
		
		int myOddNumbers[] = extractOddNumbers(matrix);
		printArray(myOddNumbers);
		
		
	}//main ends here
	
	public static int[] extractOddNumbers(int matrixArr[][]) {
		int oddNumbers[] = new int[matrixArr.length * matrixArr[0].length];
		int indexForOdds = 0;
		for(int i=0; i<matrixArr.length; i++) { // this double 'for' block is to assign the odd numbers from the 'matrix' to 'oddNumbers' array.
			for(int j=0; j<matrixArr[i].length; j++) {
				if(matrixArr[i][j] % 2 == 1) {
					oddNumbers[indexForOdds] = matrixArr[i][j];					
					indexForOdds++;					
				}
			}
		}
		return oddNumbers;
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}//class ends here
