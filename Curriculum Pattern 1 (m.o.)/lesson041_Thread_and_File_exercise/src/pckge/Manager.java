
package pckge;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1- Ogrenci sınıfı oluşturalım, 2 tane constructor'ı olsun;
 * 	  birinde sadece isim olsun, diğerinde hem isim hem 
 * 	  ortalama olsun.
 * 2- Dosyamızı okuyup gelen verilerden öğrenci yaratıp
 * 	  bunları bir listeye atalım. Daha sonra bu listeyi 
 * 	  yazdıralım (ilk başta oğrenci oluştururken sadece 
 * 	  isimlerle oluşturalım).
 * ÖDEV:
 * 3- Ogrenci listesinden bir serileştirme işlemi ile oğrencileri
 * 	  bir dosyaya yazalım.
 * 4- Serileştirip yazdığımız dosyadan gelen öğrenci verilerini
 * 	  okuyup consol'a yazdıralım. 
 */
public class Manager {
	
	File myFile = new File("E:/COURAGE/DERSLERIM/Software Lesson/Java Lesson/Curriculum Pattern 1 (m.o.)/lesson041_Thread/src/pckge/Veriler -Ogrenci Listesi.txt");
	List<Ogrenci> ogrenciListesi = new ArrayList<>();

	public static void main(String[] args) {
		
		Manager manager = new Manager();
		manager.dosyadanVeriAlVeVeridenOgrencilerOlusturupOgrenciListesineEkle_1();
//		manager.dosyadanVeriAlVeVeridenOgrencilerOlusturupOgrenciListesineEkle_2();
//		manager.yazdirOgrenciListesi();
		manager.serilestirerekDosyayaYaz_1(manager.ogrenciListesi);
//		manager.serilestirerekDosyayaYaz_2(manager.ogrenciListesi);
		manager.deserializationDosyadanOkuVeEkranaYazdir_1();
//		manager.deserializationDosyadanOkuVeEkranaYazdir_2();
		
	}//MAIN ENDS HERE ------
	
	public void dosyadanVeriAlVeVeridenOgrencilerOlusturupOgrenciListesineEkle_1() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));			
			String currentRow;
			String currentStudentName = null;
			while((currentRow = reader.readLine()) != null) { // Önemli bir kullanım.
				currentStudentName = currentRow.substring(0,currentRow.indexOf(","));
				createNewStudentAndAddStudentToStudentList_1(currentStudentName);
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void dosyadanVeriAlVeVeridenOgrencilerOlusturupOgrenciListesineEkle_2() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));			
			String currentRow;			
			String[] elementsOfRow;			
			while((currentRow = reader.readLine()) != null) { // Önemli bir kullanım.
				elementsOfRow = currentRow.split(",");
				// Oluşturduğumuz array'i bir metoda verelim, bu metot bize ortalama notu dönsün.
				createNewStudentAndAddStudentToStudentList_2(elementsOfRow);
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void createNewStudentAndAddStudentToStudentList_1(String studentName) {
		Ogrenci ogrenci = new Ogrenci(studentName);
		ogrenciListesi.add(ogrenci);
	}
	
	public double createNewStudentAndAddStudentToStudentList_2(String[] strArr) {
		// --- Yukardaki kodları stream() ile yazacak olursak:
		List<String> arrayList = new ArrayList<>(Arrays.asList(strArr));		
		double average = ortHesapla(arrayList);
		// ------
		Ogrenci ogrenci = new Ogrenci(strArr[0], average);
		ogrenciListesi.add(ogrenci);
		return average;
	}
	
	public double ortHesapla(List<String> elementsOfStudent) {		
		elementsOfStudent.remove(0); // I removed the first element which is 'String name'
		double average = elementsOfStudent.stream().collect(Collectors.averagingDouble(x -> Double.parseDouble(x)));
		return average;
	}
	
	public void yazdirOgrenciListesi() {
		ogrenciListesi.forEach(System.out::println);
	}
	
	public void serilestirerekDosyayaYaz_1(List<Ogrenci> ogrList) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("E:/serilestirmeOgrenciler.txt");
			oos = new ObjectOutputStream(fos);
			for(Ogrenci ogrenci : ogrList) {
				oos.writeObject(ogrenci); // ogrenci objelerini tek tek dosyaya yazar.
			}
			oos.close();
			System.out.println("Başarıyla dosyaya yazıldı (serileştirme).");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serilestirerekDosyayaYaz_2(List<Ogrenci> ogrList) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("E:/serilestirmeOgrenciler.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ogrList); // dosyaya yazar (bir arrayList olarak dosyaya yazar)
			oos.close();
			System.out.println("Başarıyla dosyaya yazıldı (serileştirme).");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deserializationDosyadanOkuVeEkranaYazdir_1() { // ogrenci objeleri olarak okuyacak
		try {
			FileInputStream fis = new FileInputStream("E:/serilestirmeOgrenciler.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Ogrenci> ogrListDeserialized = new ArrayList<>();
			Ogrenci currentOgrenciObject;
			while(true) { // this loop reads the objects one by one, until the end of the file.
				try {
					currentOgrenciObject = (Ogrenci)ois.readObject();
				}catch(EOFException e) {
					break; // reached the end of the file.
				}
				ogrListDeserialized.add(currentOgrenciObject);
			}
			ogrListDeserialized.forEach(System.out::println);
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deserializationDosyadanOkuVeEkranaYazdir_2() { // arrayList olarak okuyacak
		try {
			FileInputStream fis = new FileInputStream("E:/serilestirmeOgrenciler.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Ogrenci> ogrListDeserialized = (List<Ogrenci>) ois.readObject(); // tek bir seferde (döngü kullanmadan) arrayList'i dosyadan aldık.
			ogrListDeserialized.forEach(System.out::println);
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}//CLASS ENDS HERE -----
