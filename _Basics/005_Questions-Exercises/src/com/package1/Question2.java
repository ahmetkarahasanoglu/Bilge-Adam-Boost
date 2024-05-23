package com.package1;

public class Question2 {

	public static void main(String[] args) {
		
/* Bir ürünün fiyatında %18 KDV ve %15 kar vardır.
 * Ürünün ham fiyatını bulunuz (karsız ve KDV'siz)
 * */

		// **** Benim Çözümüm ****
		float price, raw, profit, kdv, k;	
		price = 250;
		k = price / 118;
	    raw = 85*k;
	    profit = 15*k;
	    kdv = 18*k;
		System.out.println(raw);
		
		// **** Hocanın Çözümü: ****
		float rawPrice = 0, price2 = 118, priceWithoutVat;
		priceWithoutVat = price2 / 1.18f;
		System.out.println("kdv'siz fiyat: " + priceWithoutVat);
		rawPrice = (priceWithoutVat / 100) * 85;
		System.out.println("ham fiyat: " + rawPrice);
		
	}

}
