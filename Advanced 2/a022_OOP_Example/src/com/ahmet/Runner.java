package com.ahmet;

import com.ahmet.entity.Kedi;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		Kedi kedi = new Kedi();
		kedi.beslenmesekli = "Etobur";
		System.out.println("Hayvan beslendi mi?: " + kedi.yemekYe("havuç otu"));
		
		System.out.println("Yaşı....: " + kedi.yas);
		for(int i=0; i<1000; i++) { // 1000 gün ilerletiyoruz 
			kedi.yaslandir();
		}
		System.out.println("Yaşı....: " + kedi.yas);
		for(int i=0; i<2400; i++) {
			System.out.print("* ");
			kedi.birSaat();
			Thread.sleep(1000);
		}
		System.out.println("Yaşı....: " + kedi.yas);
	}//main ends here

}//class ends here

