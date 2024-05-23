package com.ahmet;

public class Methods1 {

	public static void main(String[] args) {
		
		ekranaYaz();	
		

	}//end of main
	
	public static void ekranaYaz() {
		System.out.println("*******************");
		System.out.println("*******************");
		System.out.println();
	}
	
	/* Aşağıdaki 'HerhangiBirIslem' metodunu inceleyelim:
	 * public --> Access Modifier (Erişim Belirteci). kullanmak zorunlu değildir.
	 * static --> sabit adresli değişkeni ifade eder. Zorunlu değildir.
	 * final --> değişmezliği garanti eder. Zorunlu değildir.
	 * Return Type --> geri dönüş tipi (bu örnekte 'Object' olarak belirlenmiş)
	 * Method name --> should start with small letter. And camel-cased.
	 * Paranthesis () --> for parameters
	 * return --> return value. Must match with the return type specified in the description.
	 */
	public static final Object herhangiBirIslem(int sayi, boolean durum, String ifade) {
		// code
		return null;
	}
	
}//end of class
