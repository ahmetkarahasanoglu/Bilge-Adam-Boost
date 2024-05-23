package com.ahmet;

public class Runner {
	// The variables and methods that are defined as 'static' has a 
	// fixed place in memory. 

	public static void main(String[] args) {		
		Musteri musteri = new Musteri(); // this operation assigns an address to 'musteri' variable.
		Musteri.postCode = "34000"; // we accessed to a static variable through its classname.
		musteri.ad = "Hakan";
		System.out.println("Müşteri nesnesi...: " + musteri); // Output...: com.ahmet.Musteri@5305068a
		System.out.println("Müşteri adı.......: " + musteri.ad); // Output: Hakan
		System.out.println("Müşteri posta kodu: " + musteri.postCode); // Output: 34000
		musteri = new Musteri();
		System.out.println("Müşteri nesnesi...: " + musteri); // Output...: com.ahmet.Musteri@65b54208
		System.out.println("Müşteri adı.......: " + musteri.ad); // Output: null
		System.out.println("Müşteri posta kodu: " + musteri.postCode); // Output: 34000

	}//main ends here

}//class ends here
