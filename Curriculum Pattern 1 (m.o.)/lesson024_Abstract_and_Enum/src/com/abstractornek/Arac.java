package com.abstractornek;
/*
 * Bu 'Arac' sınıfını abstract yaptık. Abstract sınıflardan new'lenerek
 * nesne oluşturulamaz. Zaten 'Arac' sınıfından oluşturacağımız nesne 
 * bizim bi işimize yaramazdı; araç dediğin uçak olur, araba olur. 
 * Abstract'ın mantığı da bu. Abstract sınıflar, alt sınıfların miras
 * alması içindir.
 */
public abstract class Arac {  // abstract sınıf

	double hiz;
	
	public void hiziGoster() {  // normal metot. Alt sınıf otomatik sahip olur. İstersek alt sınıfta override edebiliriz de.
		System.out.println("Aracın hızı: " + hiz);
	}
	
	public abstract void ilerle();  // abstract metot. Alt sınıf override etmek zorunda.
	public abstract void dur();		// abstract metot. Alt sınıf override etmek zorunda.

}
