package com.ahmet;

public class MyArray {
/* Bu sınıfta bir String dizisi olacak, bu diziyi geçici bir
 * dizi kullanarak genişletebilirsiniz, ya da küçültebilirsiniz.
 * Dizinin uzunluğunu bir int değerde tutabilirsiniz.
 */

//	String[] ifadeler; // --> (teacher's code)
	String[] ifadeler = new String[0]; // 'ifadeler' is our array which the things will be added to or removed from, etc.
	int length = 0;
	
	public void add(String item) {	
		length++;
		String[] temp = new String[length];
		for(int i=0; i<length-1; i++) {
			temp[i] = ifadeler[i];
		}
		temp[length-1] = item;
		ifadeler = temp;
		// ---Teacher's Code:---
//		length++;
//		String[] temp = ifadeler;
//		ifadeler = new String[length];
//		for(int i=0; i<length; i++) {
//			if(i==length-1) {
//				ifadeler[i] = item;
//			}else {
//				ifadeler[i] = temp[i];
//			}
//		}		
		
	}		
	
	
	public void remove(int index) {
		String[] temp = new String[ifadeler.length-1];
		int indexForTempArr = 0;
		for(int i=0; i<ifadeler.length; i++) {
			if(i != index) {
				temp[indexForTempArr] = ifadeler[i];
				indexForTempArr++;
			}			
		}
		ifadeler = temp;
		// ---Teacher's Code:---
//		String[] temp = ifadeler;
//		length--;
//		ifadeler = new String[length];
//		for(int i=0; i<temp.length; i++) {
//			if(i==index) continue;
//		if(i<index) ifadeler[i]=temp[i];
//		else ifadeler[i-1]=temp[i];
//		}
	}
	
	public String[] addIndex(String item, int index) { // araya ekleme
		String[] temp = new String[ifadeler.length+1];
		for(int i=0; i<temp.length; i++) {
			if(i<index) {
				temp[i] = ifadeler[i];
			}else if(i==index) {
				temp[i] = item;
			}else if(i>index) {
				temp[i] = ifadeler[i-1];
			}
		}
		ifadeler = temp;
		length++;
		return ifadeler;
		// ---Teacher's Code:---
//		if(index==length) {
//			add(item);
//		}else {
//			String[] temp = ifadeler;
//			length++;
//			ifadeler = new String[length];
//			for(int i=0; i<temp.length; i++) {
//				if(i==index) {
//					ifadeler[i] = item;
//					ifadeler[i+1] = temp[i];
//				}
//				else if(i>index)
//					ifadeler[i+1] = temp[i];
//				else
//					ifadeler[i] = temp[i];
//			}
//		}
	}
	
	
	public String[] list() {
		return ifadeler;
	}
	public int size() {
		return length;
	}
}
