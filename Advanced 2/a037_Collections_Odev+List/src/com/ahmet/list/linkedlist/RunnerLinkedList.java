package com.ahmet.list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunnerLinkedList {

	public static void main(String[] args) {
		
		List<String> isimListesi = new ArrayList();
		System.out.println("****** ARRAYLIST *******");
		isimListesi.add("Ahmet");
		isimListesi.add("Canan");
		isimListesi.add("Deniz");
		isimListesi.add("Kenan");
		isimListesi.forEach(System.out::println);
		System.out.println();
		
		System.out.println("****** LIST - LINKED ******");
		List<String> linkedList = new LinkedList<String>(); // left side 'List', right side 'LinkedList'.
		linkedList.add("Deniz");
		linkedList.add("Hakan");
		linkedList.add("Türkan");		
		linkedList.forEach(x-> System.out.println(x));
		System.out.println();
		
		System.out.println("****** LINKEDLIST *******");
		LinkedList<String> bagliIsimListesi = new LinkedList<String>(); // left side 'List', right side 'LinkedList'.
		bagliIsimListesi.add("Deniz");
		bagliIsimListesi.add("Hakan");
		bagliIsimListesi.add("Türkan");
		bagliIsimListesi.forEach(x-> System.out.println(x));
		System.out.println();
		
		

	}//MAIN ENDS HERE ---------

}//CLASS ENDS HERE ---------
