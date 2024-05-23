package com.package2;

public class Question35 {

	public static void main(String[] args) {
		
	/* Soru: Bir dizide ard arda gelen 2 indexdeki sayı değeri 2 ise true
	 * yazdırıp döngü sonlansın. Değilse false yazdırsın.	 
	 */
		int[] numbers = {2, -256, 16, 1258, 5, 2};
		
		// ******** TEACHERS's SOLUTION **********
		boolean result = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 2 && numbers[i + 1] == 2) {
                result = true;
                break;
            }
        }

        System.out.println("Arda arda iki indexte 2 değerinde sayı var mı?: " + result);
        
        
		// ******* MY SOLUTION (unnecessarily long, bad.) *********
//		int indexOfFirstOccur = Integer.MIN_VALUE; // just to give an initial value.
//		boolean isFirstOccurFound = false;
//		boolean result = false;
//		
//		for(int i=0; i<numbers.length; i++) {			
//			if(numbers[i] == 2) {
//				if(isFirstOccurFound) {
//					if(i == indexOfFirstOccur+1) {
//						result = true;
//						break;
//					}
//				}
//				isFirstOccurFound = true;
//				indexOfFirstOccur = i;
//			}
//			
//		}
//
//		System.out.println("Arda arda iki indexte 2 değerinde sayı var mı?: " + result);
		
	}
}
