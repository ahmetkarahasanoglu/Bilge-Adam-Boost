package pckge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *	System.out.println("0- Çıkış");
	System.out.println("1- Dosya Yarat");
	System.out.println("2- Ekle");
	System.out.println("3- Okuma");
	System.out.println("4- Harf Değiştir");
	System.out.println("5- Dosya silme");
	System.out.println("lütfen işlem seçiniz");
 *
 *
 * 1- FileSabitler dosyasında bir file yaratalım. Daha sonra 
 * 	  bu file'ı bütün metotlarımızda kullanacağız. 
 * 	  Dosya yaratmak için bir metot yazalım. Eğer dosyamız 
 * 	  dizinde yoksa yaratsın, varsa bize bir çıktı versin "bu 
 * 	  dosya daha önce oluşturulmuştur.
 * 2- Dosyamıza dışardan aldığımız bir veriyi ekleyelim
 *    (Scanner ile aldığımız veriyi). Ve her ekleme yapıldıktan
 *    sonra bir sonraki ekleme işlemi alt satıra geçsin.
 * 4- Harf değiştirme: dısardan girdiğimiz bir deger metin içerisinde varsa o degeri dısardan 
 *	  girdiğimiz 2. deger ile degistirip dosyaya geri yazalım. 
 *
 *5-  eger dosya varsa silelim yoksa dosya bulunamamıstır diye çıktı verelim
 */
public class FileIslemler {
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		FileIslemler fileIslemler = new FileIslemler();
//		fileIslemler.dosyaYarat2();
//		fileIslemler.dosyayaVeriEkle();
//		fileIslemler.dosyadanVeriAl();
//		fileIslemler.harfDegistir();
		fileIslemler.dosyaSil(FileSabitler.file);
		
	}//MAIN ENDS HERE -----
	
	public void dosyaYarat() {
		try {
			if(!FileSabitler.file.exists()) {
				FileSabitler.file.createNewFile();
				System.out.println(FileSabitler.file.getName() + " başarıyla oluşturulmuştur.");
			}else {
				System.out.println("Dosya daha önce yaratılmıştır.");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dosyaYarat2() {
		try {
			if(FileSabitler.file.createNewFile()) { // we put the command inside the paranthesis of 'if' [compared to the dosyaYarat1() ]
				System.out.println(FileSabitler.file.getName() + " başarıyla oluşturulmuştur.");
			}else {
				System.out.println("Dosya daha önce yaratılmıştır.");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dosyayaVeriEkle(String text, boolean willAppendOtherwiseOverwrite) { 
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileSabitler.file, willAppendOtherwiseOverwrite)); // if 'true' (the second parameter in paranthesis) : enables to append the text; otherwise(false) overwrite the whole file.
			writer.write(text + "\n");
			writer.flush();
			System.out.println("Metin başarıyla dosyaya kaydedilmiştir, dosya: " + FileSabitler.file.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String dosyadanVeriAl() {
		String tumMetin = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileSabitler.file));
			String deger;
			while((deger = reader.readLine()) != null) { // Önemli bir kullanım.
//				System.out.println(deger);
				tumMetin += deger + "\n";
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("---");
//		System.out.println(tumMetin);
		return tumMetin;
	}
	
	public void harfDegistir() {
		System.out.print("Bulunacak harfi giriniz: ");
		String bulunacakHarf = scanner.nextLine();
		System.out.print("Yeni harfi giriniz: ");
		String yeniHarf = scanner.nextLine();
		String tumMetin = dosyadanVeriAl();
		
		tumMetin = tumMetin.replace(bulunacakHarf, yeniHarf);		
		
		dosyayaVeriEkle(tumMetin, false);
	}
	
	public void dosyaSil(File file) {
		if(file.exists()) {
			System.out.println("Dosyanız siliniyor...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			file.delete();
			System.out.println(file.getName() + " adlı dosyanız silinmiştir.");
		}else {
			System.out.println("Dosya bulunamamıştır.");
		}
	}
	
	public void dosyaSil2 (Path path) {
		try {
			if(Files.deleteIfExists(path)) {
				System.out.println("Dosyanız siliniyor...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				System.out.println(path.toString() + " adlı dosyanız silinmiştir.");
			}else {
				System.out.println("Dosya bulunamamıştır.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}//CLASS ENDS HERE -----
