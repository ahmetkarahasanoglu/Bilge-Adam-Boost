package com.ahmet;

import com.ahmet.repository.entity.Musteri;

public class Runner {

	public static void main(String[] args) {
		
/*
 * Sınıf, Değişken, Method: bunların erişim seviyelerin belirlemek için 
 * Access Modifier (Erişim Belirleyicileri) kullanılır. 
 * 1- Public --> tüm düzeylerden sınırsız erişim sağlar.
 * 2- Private --> tüm erişimleri kapatır. Sadece sınıf içinden erişim yapılır.(sadece o dosya içinde, yani o sayfa içinde erişilebilir).
 * 3- Protected --> paket korumalı erişim. Aynı paket içiden erişim
 * 					sağlanabilir. 
 * 4- Default (package-private) --> boş bırakılması (erişim belirteci kullanılmamması). Paket
 * 				  dışından erişim sağlanamaz.
 * 
 * Difference between Protected and Default: 
 * - Protected allows access in subclasses even if they're in different packages.
 * - Default (package-private) restricts access to within the same package.
 */
		
		Musteri musteri = new Musteri();
		musteri.ad = "Ahmet";
		musteri

	}//main ends here

}//class ends here
