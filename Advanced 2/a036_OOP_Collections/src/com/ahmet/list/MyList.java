package com.ahmet.list;

public class MyList<T> { // Generic Type kullanıyoruz
	
	int size = 0;
	T[] dizi;
	
	
	public void add(T item) {
		if(size==0) {
//			dizi = new T[1];  // hata veriyor. 'T' (generic) ve 'length' belirtmek beraber kullanılamıyor. Genel fikrimiz olması için yazdık bu kodları.
			dizi[0] = item;			
		}else {
			T[] temp = dizi;
			size++;
//			dizi = new T[size];
			for(int i=0; i<temp.length; i++) {
				dizi[i] = temp[i];				
			}
			dizi[size-1] = item;
		}
	}
}
