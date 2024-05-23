package com.ahmet;

public class Question_homework2 {

	public static void main(String[] args) {
// Bir dizi içerisinde tekrar eden elemanların kaç kere tekrar
// ettiğini bulunuz.
		
		// ******* MY SOLUTION: *******
		int[] arr = { 1, 5, 1, 9, 5, 1, 9, 8, 0, 0 };
		int[][] uniquesArr = new int[5][2];
		boolean isFound = false;
		int indexForUniquesArr = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<uniquesArr.length; j++) {
				if(uniquesArr[j][0] == arr[i]) {
					isFound = true;
				}
			}
			if(!isFound) {
				uniquesArr[indexForUniquesArr][0]= arr[i];
				indexForUniquesArr++;
			}
			isFound = false;
		}
		
		for(int i=0; i<uniquesArr.length; i++) {
			int count = 0;
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == uniquesArr[i][0]) {
					count++;
				}
			}
			uniquesArr[i][1] = count;
		}
		
		for(int i=0; i<uniquesArr.length; i++) {
			System.out.println(uniquesArr[i][0] + " sayısı " + uniquesArr[i][1] + " adet bulunmaktadır.");			
		}
		
		
	}//main ends here
}//class ends here
