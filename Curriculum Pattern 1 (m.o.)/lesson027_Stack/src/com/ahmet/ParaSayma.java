package com.ahmet;

import java.util.Stack;

public class ParaSayma {

	public static void main(String[] args) {
/*
 * Bir stack oluşturacağız. Stack'e 5-6 tane değer ekleyeceğiz.
 * 100 tl'den yüksek olanları toplam değerine ekleyelim,
 * küçük olanları da başka bir stack'e ekleyelim. En sonunda
 * da toplamı ve yeni oluşturduğumuz stack'i yazdıralım.
 */
		int[] genelKumbara = {100, 50, 10, 200, 20, 5, 200, 50, 20};
		
		Stack<Integer> yiginBuyukParalar = new Stack<>();
		Stack<Integer> yiginKucukParalar = new Stack<>();
		
		int total = 0;
		
		for(int i=0; i<genelKumbara.length; i++) {
			if(genelKumbara[i] >= 100) {
				yiginBuyukParalar.push(genelKumbara[i]);
				total += genelKumbara[i];
			}else {
				yiginKucukParalar.push(genelKumbara[i]); 
			}
		}
		
		System.out.println("Büyük Paralar Yığını: ");
		int size = yiginBuyukParalar.size();
		for(int i=0; i<size; i++) {
			System.out.println(yiginBuyukParalar.pop());
		}
		System.out.println("'total' değeri: " + total);
		
		System.out.println("Küçük Paralar Yığını: ");
		size = yiginKucukParalar.size();
		for(int i=0; i<size; i++) {
			System.out.println(yiginKucukParalar.pop());
		}
		System.out.println("---------------------------");
		
		
		
		// TEACHER'S CODE: ------------------
		Stack<Integer> paralar = new Stack<>();
		int toplam = 0;
		Stack<Integer> yuztldenKucukParalar = new Stack<>();
		paralar.push(120);
		paralar.push(12);
		paralar.push(250);
		paralar.push(180);
		paralar.push(80);
			
		
		while(!paralar.isEmpty()) {			
			if(paralar.peek() > 100) {
				toplam += paralar.pop();
			}else {
				yuztldenKucukParalar.add(paralar.pop());
			}			
		}
		System.out.println("toplam: " + toplam);
//		yuztldenKucukParalar.forEach(System.out::println);
		yuztldenKucukParalar.forEach(x->System.out.println(x));
		
		
		
		

	}//main ends here

}//class ends here
