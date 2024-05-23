package com.ahmet;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		System.out.println("******************************");
		System.out.println("********** ÖZEL DİZİ *********");
		System.out.println("******************************");
		System.out.println();

		int secim = 0;
		MyArray myarray = new MyArray();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1- Ekle");
			System.out.println("2- Listele");
			System.out.println("3- Sil");
			System.out.println("4- Belli bir indekse ekle");
			System.out.println("0- ÇIKIŞ");
			System.out.print("Seçiniz......: ");
			secim = sc.nextInt();
			sc.nextLine(); // dummy
			switch(secim) {
				case 1: 
					System.out.print("Eklenecek ifade.....: ");
					String ifade = sc.nextLine();
					myarray.add(ifade);
					break;
				case 2: 
					System.out.println();
					System.out.println("***************************");
					System.out.println("***** İfade Listesi: ******");
					System.out.println("***************************");
					for(int i=0;i<myarray.list().length; i++) {
						System.out.println(myarray.list()[i]);
					}
					break;
				case 3: 
					System.out.println("Silmek istediğiniz kayıt: ");
					int index = sc.nextInt();
					myarray.remove(index);
					break;
				case 4:
					System.out.print("Kaçıncı indekse eklemek istersiniz?: ");
					int index2 = sc.nextInt();
					sc.nextLine(); // dummy
					System.out.print("Ekleyeceğiniz elemanın giriniz: ");
					String newElement = sc.nextLine();
					myarray.addIndex(newElement, index2);
					break;
				case 0: System.out.println("ÇIKIŞ YAPILDI."); break;
				default:
					throw new IllegalArgumentException("Unexpected Value: " + secim);
			}
		}while(secim!=0);
		
		
		
		
	}//main ends here

}//class ends here
