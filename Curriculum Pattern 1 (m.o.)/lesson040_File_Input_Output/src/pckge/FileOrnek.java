package pckge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOrnek {
	
	public static void main(String[] args) {
	
		/**
		 * Output --> Yazma İşlemi
		 * Input  --> Okuma İşlemi
		 */
		
		try {
			// *** BASİT TİP YAZDIRMA - OKUMA İŞLEMİ YAPALIM (byte byte işlem) ***
			FileOutputStream fos = new FileOutputStream("E:/deneme2.txt");
			FileInputStream fis = new FileInputStream("E:/deneme2.txt");
				
//			fos.write(65);
//			fos.write(80);	
//			byte[] array = { 101, 85, 88 };
//			fos.write(array);
			String str = "Merhaba dunya";
			fos.write(str.getBytes());
				
			int deger;
			while((deger = fis.read()) != -1) { // Önemli bir kullanım şekli
				System.out.println((char)deger); // '--> fis.read() returns -1 if the end of the file is reached.
			}
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println(fis.read()); 
//			System.out.println(fis.read());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//MAIN ENDS HERE ------
	
}//CLASS ENDS HERE -----
