package pckge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOrnek2 {

	public static void main(String[] args) {
		
		String path = "E:/deneme3.txt";
		File file = new File(path);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
//			FileWriter fileWriter = new FileWriter(file);
//			BufferedWriter writer2 = new BufferedWriter(fileWriter);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // 'true' means 'append data'; Not overwrite the file. Any new data will be added to the end of the existing content.
			writer.write("satır1\n");
			writer.write("satır2\n");
			writer.flush();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String deger;
//			while((deger = reader.readLine()) != null) {
//				System.out.println(deger);
//			}
			
			// - Scanner ile okumayı da yapalım:
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				System.out.println(input.nextLine());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}//MAIN END HERE -----

}//CLASS ENDS HERE ----
