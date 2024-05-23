package pckge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Ogretmen sınıfını thread yapalım.
 * run metodu yazalım, run metodunda 10 kere dönsün, çıktı
 * olarak da:
 * ogretmen ismi --> "1'nci öğrencinin notlarını okudu
 * ogretmen ismi --> "2'nci öğrencinin notlarını okudu
 *  
 * OgretmenTest sınıfı oluşturalım, burda test edecez, 2 tane
 * öğretmen oluşturalım. 
 * -----
 * 
 * Öğretmenler aynı dosya üzerinde (ogrencilerin verilerinin
 * olduğu txt dosyasından) okuma yapıp okudukları 
 * verileri kendi sınıfları içerisinde tuttukları öğrenci 
 * listesine ekleyecekler. Bunu bir thread yapısı üzerinden
 * kuracağız.
 * 
 * ogretmenTest sınıfında 2 tane ogretmenimiz olacak, bu 
 * thread'ler çalıştıracağız. En sonunda da, kaç tane 
 * öğrencinin notunu okumuşlar onu göstereceğiz.
 */
public class Ogretmen extends Thread { // pay att: extends Thread

	String name;
	List<Ogrenci> ogrenciler = new ArrayList<>();
	BufferedReader bufferedReader;

	public Ogretmen(String name, BufferedReader bufferedReader) {
		super();
		this.name = name;
		this.bufferedReader = bufferedReader;
	}
	
	@Override
		public void run() {			
			
			try {
				String line;
				while((line = bufferedReader.readLine()) != null) {
					String[] array = line.split(",");
					double ort = ortHesapla(Arrays.asList(array));
					Ogrenci ogrenci = new Ogrenci(array[0], ort);
					ogrenciler.add(ogrenci);
					
					System.out.println(name + " --> " + ogrenci.getName() + " adlı öğrenciyi ekledi.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	
	public double ortHesapla(List<String> list) {
		return list.subList(1, list.size()).stream().collect(Collectors.averagingDouble(x -> Double.parseDouble(x)));
	}
	
}
