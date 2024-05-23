package com.ahmet;

import com.ahmet.repository.MusteriRepository;

public class Runner {

	public static void main(String[] args) {
/*
 * final : başına geldiği değerin değişmezliğini garanti eder.
 * 1- Bir değişkeni nitleyebilir. Değişkenin değeri atama 
 * yapıldıktan sonra değiştirilemez.
 * 2- Değişkenlerde kullanımında değişkene ilk değerinin atanması
 * zorunludur. Yani değişken önce tanımlanıp sonra değeri atanamaz.
 * Burada mantık şöyle işlemektedir; final değişkenler uygulama
 * başlarken değerleri atanmış olarak başlanmalıdır. Bu nedenle
 * bu değişkenlere ilk değer atanabileceği gibi atama işlemi 
 * constructor'larda da yapılabilir.
 * 3- Metotlarda da 'final' kullanılır. Metodun değişmezliğini
 * sağlar. O metodun override edilememesini sağlar.
 * 4- Sınıfların başına da 'final' konulabilir. Sınıfın
 * değişmezliğini garanti eder. O sınıfı başka hiçbir sınıf miras
 * alamaz. [Yani o sınıf nirvanaya ermiştir; kimse onu miras
 * almasın, onda bir değişiklik olacaksa ben kendim yeni sürümünü
 * yazarım.]
 */
		final String programName = "Ahmet Otomasyon";		
//		programName = "Mehmet";  // değiştiremeyiz, hata verir.
		MusteriRepository repo = new MusteriRepository();
		repo.deleteMethod;
		
		

	}

}
