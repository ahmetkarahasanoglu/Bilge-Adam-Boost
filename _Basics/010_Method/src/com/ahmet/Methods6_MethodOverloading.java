package com.ahmet;

public class Methods6_MethodOverloading {

	public static void main(String[] args) {
		
		topla(12, 7);
		topla(23, 6.9);
		topla(5, 10.5, 15.7f);
		
		
		
		
	}//main sonu
	
	/* Metodlar aynı isim ve aynı parametreleri alarak kullanılamazlar.
	 * Aynı isim kullanılarak yazılacak metotlar için içerisine 
	 * aldığı parametrelerin farklı olması gerekir.
	 * 
	 * We can use two functions with the same name but with 
	 * different parameters. These methods can have the same 
	 * name but differ in the number, types, or order of their 
	 * parameters. 
	 */
	public static void topla(int num1, int num2) {
		
	}
	public static void topla(int num3, double num4) {
		
	}
	public static void topla(int s1, double s2, float s3) {
		
	}
	
	
	public void saveProduct() {}
	public void saveUser() {}
	public void saveAccount() {}
	// instead of the above 3 methods, we can use:
//	public void save(Porduct product) {}
//	public void save(User user) {}
//	public void save(Account account) {}
	
}//class sonu
