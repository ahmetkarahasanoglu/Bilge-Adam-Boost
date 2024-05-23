package com.package3;

import java.util.Scanner;

public class Question47 {

	public static void main(String[] args) {
		
/*
 * Hesap makinesi oluşturacağız.
 * 1-Topla
 * 2-Cıkar
 * 3-Çarp
 * 4-Böl
 * 5-İki sayı gireceğiz. Ebob ve Ekok'unu yazdıracak.
 * 0-Çıkış
 * 
 * Döngümüz olacak. Döngüde işlem seçeceğiz.
 * 1- Toplama: Kullanıcının girdiği sayıları, kullanıcı '=' girene kadar
 * toplasın ve ekrana yazdırsın.
 * 
 * 
 */
		Scanner sc = new Scanner(System.in);
		int choice = 0;		
		do {
			printMenu();
			choice = chooseOption(sc);			
			
			switch(choice) {
			case 1:
				add(sc);
				break;
			case 2:
				subtract(sc);
				break;
			case 3:
				multiply(sc);
				break;
			case 4:
				divide(sc);
				break;
			case 5:
				GCDandLCM(sc);
				break;
			case 0:
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid selection in the menu!");
			}			
		}while(choice != 0);		
		
		sc.close();
	}//main sonu
	
	public static void printMenu() {
		System.out.println("------------------------------------------");
		System.out.println("CALCULATOR PROGRAM. PLEASE SELECT AN OPTION.");
		System.out.println("1-Add");
		System.out.println("2-Subtract");
		System.out.println("3-Multiply");
		System.out.println("4-Divide");
		System.out.println("5-Find GCD and LCM of two numbers. (Greatest Common Divisor and Least Common Multiple)");
		System.out.println("0-Exit");
	}
	
	public static int chooseOption(Scanner scan) {		
		String inputStr = scan.nextLine();
		int choice = -1;
		try {
			choice = Integer.parseInt(inputStr);
		}catch(NumberFormatException e){
			
		}
			
		return choice;
	}
	
	public static void add(Scanner sc) {
		System.out.println("'Add' operation. Please enter as many numbers as you want. Then, enter '='.");
		String inputStr = "";				
		int total = 0;
		while(!inputStr.equals("=")) {
			inputStr = sc.nextLine();
			if(!inputStr.equals("=")) {
				try {
					int number = Integer.parseInt(inputStr);							
					total += number;
				} catch (NumberFormatException e) {							
					System.out.println("Invalid entry! Please enter a valid number or '=' to finish.");
				}						
			}
								
		}
		System.out.println("Total: " + total);
	}
	
	public static void subtract(Scanner sc) {
		System.out.println("'Subtract' Operation. Please enter as many numbers as you want. Then, enter '='.");
		int result = 0;
		String inputStr2 = "";
		boolean willSum = true;
		do{
			inputStr2 = sc.nextLine();
			if(!inputStr2.equals("=")) {
				try {
					int number = Integer.parseInt(inputStr2);
					if(willSum) { // will sum (the first time only)
						result = number;
						willSum = false;
					}else { // will subtract (second time and onwards)
						result -= number;
					}							
				}catch(NumberFormatException e) {
					System.out.println("Invalid entry! Please enter a valid number or '=' to finish.");
				}
			}
		}while(!inputStr2.equals("="));
		System.out.println("Result: " + result);
	}
	
	public static void multiply(Scanner sc) {
		System.out.println("'Multiply' Operation. Please enter as many numbers as you want. Then, enter '='.");
		int result = 0;
		String inputStr2 = "";
		boolean willSum = true;
		do{
			inputStr2 = sc.nextLine();
			if(!inputStr2.equals("=")) {
				try {
					int number = Integer.parseInt(inputStr2);
					if(willSum) { // will sum (the first time only)
						result = number;
						willSum = false;
					}else { // will subtract (second time and onwards)
						result *= number;
					}							
				}catch(NumberFormatException e) {
					System.out.println("Invalid entry! Please enter a valid number or '=' to finish.");
				}
			}
		}while(!inputStr2.equals("="));
		System.out.println("Result: " + result);
	}
	
	public static void divide(Scanner sc) {
		System.out.println("'Multiply' Operation. Please enter as many numbers as you want. Then, enter '='.");
		int result = 0;
		String inputStr2 = "";
		boolean willSum = true;
		do{
			inputStr2 = sc.nextLine();
			if(!inputStr2.equals("=")) {
				try {
					int number = Integer.parseInt(inputStr2);
					if(willSum) { // will sum (the first time only)
						result = number;
						willSum = false;
					}else { // will subtract (second time and onwards)
						result /= number;
					}							
				}catch(NumberFormatException e) {
					System.out.println("Invalid entry! Please enter a valid number or '=' to finish.");
				}
			}
		}while(!inputStr2.equals("="));
		System.out.println("Result: " + result);
	}
	
	public static void GCDandLCM(Scanner sc) {
		System.out.print("Enter first number: ");
		int num1 = sc.nextInt();
		System.out.print("Enter second number: ");
		int num2 = sc.nextInt();
		
		sc.nextLine(); // dummy
		
		int max = Integer.MIN_VALUE;
		int[] nums = {num1, num2};
		for(int i=0; i<nums.length; i++) {
			if(nums[i]>max) {
				max = nums[i];
			}
		}
		
		int num1copy = num1;
		int num2copy = num2;	
		
		// GCD (Greatest Common Divisor)
				int a = num1;
				int b = num2;
				while (b != 0) {
		            int temp = b;
		            b = a % b;
		            a = temp;
		        }        
				System.out.println("GCD: " + a);
		
		// LCM (Least Common Multiple)
//		int divisorCollector = 1;
//		int divisor = 2;
//		do {
//			if(num1copy%divisor==0 || num2copy%divisor==0) {
//				divisorCollector *= divisor;
//				if(num1copy%divisor==0) {
//					num1copy = num1copy / divisor;
//				}
//				if(num2copy%divisor==0) {
//					num2copy = num2copy / divisor;
//				}
//			}else {
//				divisor++;
//			}
//		}while(divisor <= max);
//		System.out.println("LCM: " + divisorCollector);
		int lcm = num1*num2/a;
		System.out.println("LCM: " + lcm);
		
		
	}

}//class sonu
