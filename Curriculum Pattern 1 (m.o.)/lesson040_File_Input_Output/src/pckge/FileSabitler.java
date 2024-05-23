package pckge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class FileSabitler {

	public static Path path = Path.of("E:/fileIslemler.txt");
	public static File file = new File(path.toString()); // doesn't create a file in that path. Instead, it creates an object that represents the file located at the specified path.
	
}//CLASS ENDS HERE -----
