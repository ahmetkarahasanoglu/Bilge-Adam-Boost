package com.ahmet;

import java.util.Stack;

public class YazdirmaCesitleri_stack {

	public static void main(String[] args) {
		
		Stack<Integer> paralar = new Stack<>();
		paralar.push(120);
		paralar.push(12);
		paralar.push(250);
		paralar.push(180);
		paralar.push(80);
		
//		int size = paralar.size();
//		for(int i=0; i<size; i++) {
//			System.out.println(paralar.get(i)); // prints from buttom to top.
//		}
		
//		paralar.forEach(System.out::println); // prints from buttom to top.
		
//		paralar.forEach(x->System.out.println(x)); // prints from buttom to top.
		
//		for(Integer para : paralar) {
//			System.out.println(para);    // prints from buttom to top.
//		}
		
		while(!paralar.isEmpty()) {
			System.out.println(paralar.pop());  // top to buttom
		}
		

	}//main ends here

}
