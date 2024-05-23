package com.ahmet;

import java.util.Scanner;

public class String12_Q_MovingAcharacterWithArrowKeys {

	public static void main(String[] args) {
		
	/* 
	 *  . . . . .
	 *  . . . . . 
	 *  . . * . . 
	 *  . . . . . 
	 *  . . . . . 
	 *  
	 *   Move the asterisk when pressed on these buttons on keyboard:
	 *   
	 *     8
	 *   4   6
	 *     2
	 *     
	 *  '--> these will be used as arrows to move the asterisk
	 */
		
		
		// ******** TEACHER'S SOLUTION: *********
		int x=3, y=3; // location of the asterisk (*)
		int yon;
		Scanner sc = new Scanner(System.in);
		do {
			int positionX=0, positionY=1; // current location when traversing the dots 
	        for(int i=1; i<=25; i++) {
	        	positionX = i%5;
	        	if(positionX==(x%5) && positionY==y) {
	        		System.out.print(" *");
	        	}else {
	        		System.out.print(" .");
	        	}        	
	        	if(i%5==0) {
	        		System.out.println();
	        		positionY++; // her 5 noktada bir alt satıra geçtiği için Y'yi 1 arttırıyoruz.
	        		
	        	}  	
	        }	        
	        System.out.println("Yön seçiniz: 8,4,6,2 tuşlarıyla. Çıkış için 0 giriniz.");
	        yon = sc.nextInt();
	        
	        if(yon==8) {
//	        	if(y==1) y=5; else y--;  // we can do the same thing with ternary, as shown below.
	        	y = y==1 ? 5 : y-1;
	        }else if(yon==2) {
	        	if(y==5) y=1; else y++;
	        }else if(yon==4) {
	        	if(x==1) x=5; else x--;
	        }else if(yon==6) {
	        	if(x==5) x=1; else x++;
	        }
		}while(yon != 0);
		System.out.println("Çıkış yapıldı.");
		
        
		
		// ****** CHAT GPT's SOLUTION:*******
		
//		int row = 2; // Initial row position of asterisk
//        int col = 2; // Initial column position of asterisk
//
//        while (true) {
//            // Display the grid
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    if (i == row && j == col) {
//                        System.out.print("* ");
//                    } else {
//                        System.out.print(". ");
//                    }
//                }
//                System.out.println();
//            }
//            
//            System.out.println("Press a movement key (2, 4, 6, 8 to move, or any other key to exit):");
//            
//            Scanner scanner = new Scanner(System.in);
//            int input;
//            if (scanner.hasNextInt()) {
//                input = scanner.nextInt();
//                switch (input) {
//                    case 8:
//                        if (row > 0) {
//                            row--;
//                        }
//                        break;
//                    case 2:
//                        if (row < 4) {
//                            row++;
//                        }
//                        break;
//                    case 4:
//                        if (col > 0) {
//                            col--;
//                        }
//                        break;
//                    case 6:
//                        if (col < 4) {
//                            col++;
//                        }
//                        break;
//                    default:
//                        return;
//                }
//            } else {
//                return;
//            }
//        }
        
        
	sc.close();
	}
}
