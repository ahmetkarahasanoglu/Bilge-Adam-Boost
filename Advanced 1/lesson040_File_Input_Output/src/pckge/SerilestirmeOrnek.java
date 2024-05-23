package pckge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerilestirmeOrnek {

	public static void main(String[] args) {
		
		Ogrenci ogrenci = new Ogrenci("Mustafa", 22);
		
		ObjectOutputStream oos = null;
		// Serialization İşlemi
		try {
			FileOutputStream fos = new FileOutputStream("E:/seri.txt");
			oos = new ObjectOutputStream(fos);
//			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("seri.txt"));
			oos.writeObject(ogrenci);
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		//-----------------------------------
		// DeSerialization İşlemi
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("E:/seri.txt");
			ois = new ObjectInputStream(fis);
			Ogrenci ogrenci2 = (Ogrenci)ois.readObject();			
			System.out.println(ogrenci2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		
		
		

	}//MAIN ENDS HERE ------

}//CLASS ENDS HERE -----
