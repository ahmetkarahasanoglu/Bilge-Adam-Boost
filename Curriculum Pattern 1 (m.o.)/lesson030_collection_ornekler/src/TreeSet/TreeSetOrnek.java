package TreeSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * Klavyeden rastgele 10 sayı girin,
 * ve bunu bir sete ekleyin.
 * Sonra setimizi yazdıralım.
 * 
 * NOT: !!!!!!!!!
 * - TreeSet: küçükten büyüğe sıralı şekilde tutar elemanları. string'lerde a'dan z'ye sıralar.
 * - LinkedHashSet: eklediğimiz sırayla tutar.
 * - HashSet: karışık sırada tutar.
 */
public class TreeSetOrnek {
	
//	static Set<Integer> sayilar = new HashSet<>(Arrays.asList(2, 5, 3, 6, 4, 6, 4, 2, 8, 9));
//	static Set<Integer> sayilar = new LinkedHashSet<>(Arrays.asList(2, 5, 3, 6, 4, 6, 4, 2, 8, 9));
	static Set<Integer> sayilar = new TreeSet<>(Arrays.asList(2, 5, 3, 6, 4, 6, 4, 2, 8, 9));
	static Set<String> stringTreeSet = new TreeSet<>();
	static Set<Ogrenci> ogrenciSet = new TreeSet<>();  
		// '--> treeSet'ler comparable interface'ini implement etmiş 
		// sınıflar ile çalışır (karşılaştırılabilir bir sınıf 
		// almayı bekler). Burada 'Ogrenci' karşılaştırılabilir 
		// bir sınıf değildir - 'Ogrenci' sınıfında 'Comaparable' 
		// interface'ini implement ederek bu problem çözeriz.
	
	public static void main(String[] args) {		
		
		sayiEkle();		
		yazdir(sayilar);
		
		stringTreeSet.add("Mustafa");
		stringTreeSet.add("Ahmet");
		stringTreeSet.add("Zehra");
		stringTreeSet.add("Kemal");
		
		yazdir(stringTreeSet);
		
		ogrenciSet.add(new Ogrenci(1)); // error. 'Ogrenci' class is not sth comparabla (to sort in a TreeSet). Error text:  Exception in thread "main" java.lang.ClassCastException: class TreeSet.Ogrenci cannot be cast to class java.lang.Comparable 
		ogrenciSet.add(new Ogrenci(2)); // '--> 'Ogrenci' sınıfında 'Comaparable' interface'ini implement ederek bu problem çözeriz.
		ogrenciSet.add(new Ogrenci(3));
		ogrenciSet.add(new Ogrenci(4));
		ogrenciSet.add(new Ogrenci(55));
		ogrenciSet.add(new Ogrenci(15));
		ogrenciSet.add(new Ogrenci(23));
		ogrenciSet.add(new Ogrenci(12));
		
		yazdir(ogrenciSet);
		
	
	}//MAIN ENDS HERE ------

	public static void sayiEkle() {
		Random random = new Random();
		for(int i=0; i<10; i++) {
			Integer randNum = random.nextInt(10, 101);
			sayilar.add(randNum);
		}		
	}
	
	public static <T> void yazdir(Set<T> set) {
		set.forEach(x -> System.out.println(x));
	}
	
	
}//CLASS ENDS HERE ------
