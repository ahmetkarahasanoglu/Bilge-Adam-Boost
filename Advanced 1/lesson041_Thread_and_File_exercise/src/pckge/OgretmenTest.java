package pckge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OgretmenTest {

	public static void main(String[] args) {
		/*
		 * Burada şunu yapacağız: iki öğretmen nesnesi yaratıp,
		 * bunların aynı bufferedReader'ı kullanmasını sağlaya
		 * cağız (new'lerken parametre olarak aynı bufferedReader'ı
		 * verecez. Bunlar aynı dosyayı satır satır okuyacak,
		 * asenkron şekilde; biri bi satırı, diğeri öbür satırı
		 * okuyacak (sıra karışabilir, asenkron olduğu için).
		 */
		
		File file = new File("E:/COURAGE/DERSLERIM/Software Lesson/Java Lesson/Curriculum Pattern 1 (m.o.)/lesson041_Thread/src/pckge/Veriler -Ogrenci Listesi.txt");
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			
			Ogretmen ogretmen1 = new Ogretmen("Necati", bufferedReader); // Aynı bufferedReader'ı kullanıyor bu 2 satır.
			Ogretmen ogretmen2 = new Ogretmen("Memduh", bufferedReader);
			
			ogretmen1.start();
			ogretmen2.start();
			
			try {
				ogretmen1.join();
				ogretmen2.join(); // 'join' şunu sağlıyor: bu kodun altındaki thread'ler, önce bu kodun bitmesini bekliyor, daha sonra çalışıyor. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			try {
//				Thread.sleep(1000);			// 'join' kullandığımız zaman buraya gerek yok. 'join' zaten sağlıyor bize thread bekletilmesini. 
//			} catch (InterruptedException e) {			
//				e.printStackTrace();
//			}
			
			System.out.println(ogretmen1.ogrenciler.size());
			System.out.println(ogretmen2.ogrenciler.size());
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			try {
				bufferedReader.close(); // we closed the buffer here.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
