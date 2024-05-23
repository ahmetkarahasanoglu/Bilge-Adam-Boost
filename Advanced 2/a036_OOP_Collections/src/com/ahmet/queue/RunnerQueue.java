package com.ahmet.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RunnerQueue {
	
	public static void main(String[] args) {
		
		Queue<String> hastaneKuyrugu = new LinkedList<String>(); // Since Queue is an interface, we can't create object from it. We're applying polimorphism by using LinkedList on the right side of the assignment operation.
		System.out.println("**** HASTANE OTOMASYON ****");
		hastaneKuyrugu.add("Deniz");
		hastaneKuyrugu.add("Tekin");
		hastaneKuyrugu.add("Bahar");
		hastaneKuyrugu.add("Elvan");
		hastaneKuyrugu.add("Feriha");
		hastaneKuyrugu.add("Şener");
		hastaneKuyrugu.add("Zeynep");
		hastaneKuyrugu.forEach(x-> System.out.println(x));
		System.out.println("*********************************");
		System.out.println("Sıradaki hasta.......: " + hastaneKuyrugu.peek()); // peek() -> kuyruğun o anki başını döner. (silmez).
		System.out.println("Sıradaki hasta.......: " + hastaneKuyrugu.poll()); // poll() -> kuyruğun o anki başını döner ve siler. [ remove() ile hemen hemen aynı, yalnız kuyruk boşkenki davranışı farklı] 
		hastaneKuyrugu.forEach(x-> System.out.println(x));
		
		
	}//MAIN ENDS HERE -------
	
}//CLASS ENDS HERE ------
