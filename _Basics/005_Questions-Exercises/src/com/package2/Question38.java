package com.package2;

public class Question38 {

	public static void main(String[] args) {
		
	/* Soru: Verilen dizide 13 var ise, 13 ve bir sonraki eleman
	 * toplama eklenmeden toplam sonucunu bulan kod.
	 */
		int nums[] = { 1,13,13,13,5,1 };
//		int nums[] = { 1,13,2,3,4,13 };
		int total = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 13) {
				if(i != nums.length-1) {
					i++;
				}				
			}else {
				total += nums[i];
			}
		}
		System.out.println(total);
		
		
		
	}
}
