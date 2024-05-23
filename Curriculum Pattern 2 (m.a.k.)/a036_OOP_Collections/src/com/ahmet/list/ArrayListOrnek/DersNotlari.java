package com.ahmet.list.ArrayListOrnek;

import java.util.ArrayList;
import java.util.List;

public class DersNotlari { 

	/*
	 * DİKKAT !!!!
	 * Generic type'larda primtiive tipler kullanılamazlar. Sadece
	 * Reference Data Type'lar kullanılabilir.
	 */
	List<Integer> matematik;
//	List<int> turkce; // primitive tipler kullanılamaz Generic Type'larda.
	List<Integer> turkce;
	List<Integer> tarih;
	
	public DersNotlari() {
		this.matematik = new ArrayList();
		this.turkce = new ArrayList();
		this.tarih = new ArrayList();
	}
	
	// METHODS:
	public void matematikNotlariGir(int not1, int not2, int not3) { // Böyle bir metot da oluşturabiliriz.
		this.matematik.add(not1);
		this.matematik.add(not2);
		this.matematik.add(not3);
	}
}
