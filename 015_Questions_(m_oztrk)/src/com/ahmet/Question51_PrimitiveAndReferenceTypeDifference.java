package com.ahmet;

public class Question51_PrimitiveAndReferenceTypeDifference {

	public static void main(String[] args) {
		
/* - Primitive type'larda (int, double vs.) iki değişkeni birbirine atadığımızda
 *   bu iki değişken aynı değere sahip olur ancak bellekte farklı 
 *   adreslerdedirler.
 *   
 * - Reference Type'larda (String gibi) iki değişkeni birbirine atadığımızda
 *   bunlar bellekte aynı adresi gösterir. Bu noktadan sonra yapacağım
 *   işlemlerde, bir değişkende yaptığım değişiklik diğer değişkende de 
 *   gerçekleşir.
 * 
 */
		
		int a = 5;
		int b = 3;
		
		System.out.println(a); // 5
		System.out.println(b); // 3
		
		a = b;
		b = 8;
		
		System.out.println(a); // 3
		System.out.println(b); // 8
		
		
		
		String[] sehirler1 = { "Ankara", "İstanbul", "İzmir" };
		String[] sehirler2 = { "Bursa", "Konya", "Mersin" };
		
		System.out.println(sehirler1[0]); // Ankara
		System.out.println(sehirler2[1]); // Konya
		
		sehirler2 = sehirler1;
		System.out.println(sehirler2[0]); // Ankara
		sehirler1[0] = "Bolu";
		System.out.println(sehirler2[0]); // Bolu	 [PAY ATT.]
		sehirler2[1] = "Hatay";
		System.out.println(sehirler1[1]); // Hatay   [PAY ATT.]

	}

}
