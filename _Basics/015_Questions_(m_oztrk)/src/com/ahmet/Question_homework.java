package com.ahmet;
import java.util.Scanner;

public class Question_homework {

	public static void main(String[] args) {
// Forming square from numbers by using multidimensional array.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a one-digit number: ");
		int num = sc.nextInt();
		System.out.print("Enter number of rows: ");
		int row= sc.nextInt();
		System.out.print("Enter number of colums: ");
		int column = sc.nextInt();
		
		int[][] arr = new int[row][column];
		
		int lowest = 1;
		int highest = num;
		int middle = (int)Math.ceil(num/2.0);
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(i==j) {
					System.out.print(middle + " ");
				}else if(i<j) {
					System.out.print(highest + " ");
				}else if(i>j) {
					System.out.print(lowest + " ");
				}				
			}
			System.out.println();
		}
		

	}

}
