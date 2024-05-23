package com.ahmet.list.stack;

import java.util.List;
import java.util.Stack;

public class RunnerStack {

	public static void main(String[] args) {
		/*
		 * ***** STACK (YIĞIN) *****
		 * - LIFO (last in first out)
		 * - Vektör'den türemiştir; Vektör'den miras almıştır.
		 */
		Stack<String> postList = new Stack<String>();
		List<String> listYigit = new Stack<String>(); // bunun sol tarafı List, sağ tarafı Stack.
		postList.add("1. post");
		postList.add("2. post");
		postList.add("3. post");
		postList.add("4. post");
		postList.forEach(System.out::println);
		System.out.println("Yığıttan değer okumak:");
		String okunanDeger = postList.peek();
		System.out.println("Peek ile okunan değer.....: " + okunanDeger);
		String okunanDegerPop = postList.pop();
		System.out.println("Pop ile okunan değer......: " + okunanDegerPop);
		postList.forEach(System.out::println);
		postList.push("5. Yeni Post");
		System.out.println("*** Push İle Ekleme ***");
		postList.forEach(System.out::println);
	}//main ends here

}//class ends here
