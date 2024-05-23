package lesson034;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * 1- Öğrencilerin her birinin not ortalamasını hesaplayıp diziye
 * 	  atan stream yapısını bir metot içinde yazınız. 
 * 2- Öğrencileri bölüme göre map'leyelim, yazdıralım.
 * 3- Not ortalaması 50 ve altı olanlar için durum güncellemesi
 *    yapıp "Kaldı" olarak belirleyelim, diğerleri için "Geçti"
 *    olsun. Metodu yazınız.
 * 4- Öğrenci ismi(key) ve not ortalaması (value) map'leyen 
 *    metodu yazınız.
 * 5- Öğrencilere bir not daha ekleyen 'notEkle()' metodunu yazınınz.
 * 6- Her öğrencinin notlarına 5'e puan ekleyen metodu yazınız.
 */
public class StudentManager {
	
	List<Student> ogrenciler;
	
	// CONSTRUCTOR:
	public StudentManager() {
		baslangicVerisi();
	}	
	
	public void baslangicVerisi() {
		ogrenciler = new ArrayList<>();
		Student student1 = new Student(1, "Mustafa", "mat");
		student1.getNotlar().add(50D);
		student1.getNotlar().add(50.0);
		student1.getNotlar().add(50D);
		Student student2 = new Student(2, "Ayşe", "tm");
		student2.getNotlar().add(80D);
		student2.getNotlar().add(55D);
		student2.getNotlar().add(79.5);
		Student student3 = new Student(3, "Hakan", "tm");
		student3.getNotlar().add(86D);
		student3.getNotlar().add(97.5);
		student3.getNotlar().add(50.5);
		Student student4 = new Student(4, "Mert", "mat");
		student4.getNotlar().add(80D);
		student4.getNotlar().add(30D);
		student4.getNotlar().add(82.5);
		Student student5 = new Student(5, "Gamze", "mat");
		student5.getNotlar().add(10D);
		student5.getNotlar().add(35.7);
		student5.getNotlar().add(58.3);
		Student student6 = new Student(6, "Merve", "tm");
		student6.getNotlar().add(36D);
		student6.getNotlar().add(23.5D);
		student6.getNotlar().add(57.5);
		ogrenciler = List.of(student1, student2, student3, student4, student5, student6);
	}
	
	public void ortalamalariGoster(List<Student> ogrenciler) {
		List<Double> herBirininOrtalamalari = ogrenciler.stream()
	            .map(x-> x.getNotlar().stream()	            		
	            		.collect(Collectors.averagingDouble(z->z))
	            ).collect(Collectors.toList());
		System.out.println("--- Her Birinin Ortalamaları: ---");
		herBirininOrtalamalari.forEach(System.out::println);
		// *** 2. Çözüm (forEach'li):
//		ogrenciler.stream().forEach(x -> {
//			System.out.println(x.getNotlar().stream().collect(Collectors.averagingDouble(z->z)));
//		});
		// *** 3. Çözüm (Student sınıfındaki 'notOrtHesapla()' metodunu kullanarak:
//		ogrenciler.stream().forEach(x -> System.out.println(x.notOrtHesapla()));
		// * 3. Çözüm'ü map metoduyla yaparsak:
//		List<Double> herBirininOrtalamalari2 = ogrenciler.stream().map(x -> x.notOrtHesapla()).collect(Collectors.toList());
//		System.out.println(herBirininOrtalamalari2);
		
		System.out.println("--- Tüm Sınıfın Ortalaması: ---");
		Double sinifOrtalamasi = herBirininOrtalamalari.stream()
				.collect(Collectors.averagingDouble(x->x));
		System.out.println(sinifOrtalamasi);
		// *** Version 2:
//		Double sinifOrtalamasi2 = ogrenciler.stream().map(x -> x.notOrtHesapla()).collect(Collectors.toList()).stream()
//				.collect(Collectors.averagingDouble(y->y));
//		System.out.println(sinifOrtalamasi2);
		// *** Version 3 (Student class'ının notOrtHesapla() metodunu kullanmadan:
		Double sinifOrtalamasi2 = ogrenciler.stream()
				.collect(Collectors.averagingDouble(x -> x.getNotlar().stream().collect(Collectors.averagingDouble(y->y))));
		System.out.println(sinifOrtalamasi2);
	}
	
	public void mapOlusturBolumeGoreVeYazdir() {
		Map<String, List<Student>> bolumeGoreOgrMap = ogrenciler.stream().collect(Collectors.groupingBy(x -> x.getBolum()));
		// Or:
//		Map<String, List<Student>> bolumeGoreOgrMap2 = ogrenciler.stream().collect(Collectors.groupingBy(Student::getBolum));
		bolumeGoreOgrMap.forEach((k,v)-> System.out.println(k + " --> " + v));
		// or, for printing we can also use entrySet():
//		bolumeGoreOgrMap.entrySet().forEach(System.out::println);		
	}
	
	public void mapOlusturOgrenciIsmiVeNotOrtalamasi() {
		Map<String, Double> ogrVeNotOrtMap = ogrenciler
				.stream()
				.collect(Collectors.toMap(	  // IMPORTANT
						student -> student.getIsim(), 
						student -> student.notOrtHesapla()
				));
		System.out.println(ogrVeNotOrtMap);
	}
	
	public void notEkle() {
		ogrenciler.stream()
				.forEach(x-> x.getNotlar().add(80D)); // herkese aynı notu (80) ekler
		// Version 2 (with 'map' function)
		ogrenciler.stream().map(x -> x.getNotlar().add(80D));
		ogrenciler.forEach(student -> {
		    List<Double> updatedNotlar = student.getNotlar().stream()
		            .map(not -> not + 5)  // Add 5 to each 'not'
		            .collect(Collectors.toList());

		    student.setNotlar(updatedNotlar);
		});

	}
	
	public void notlara5puanEkle() {
		ogrenciler.stream().forEach(x -> x.setNotlar(
				x.getNotlar().stream().map(y -> y + 5.0)
				.collect(Collectors.toList())));
	}
	
	public void durumGuncellemesi() {
		ogrenciler.stream().filter(x -> x.notOrtHesapla()<=50).forEach(y -> y.setDurum("Kaldı"));
		ogrenciler.stream().filter(x -> x.notOrtHesapla()>50).forEach(y -> y.setDurum("Geçti"));
		//Or, a more concise way:
		ogrenciler.stream().forEach(s -> s.setDurum(s.notOrtHesapla() > 50 ? "Geçti" : "Kaldı"));
	}
	
}
