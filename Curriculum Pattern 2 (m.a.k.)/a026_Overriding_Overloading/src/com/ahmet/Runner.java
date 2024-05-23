package com.ahmet;

import com.ahmet.entity.DataBaseRepository;
import com.ahmet.entity.Doktor;
import com.ahmet.entity.Hasta;

public class Runner {
	
	public static void main(String[] args) {
		
		DataBaseRepository db = new DataBaseRepository();
		Hasta hasta = new Hasta();
		Doktor doktor = new Doktor();
		db.save(hasta);
		db.save(doktor);
		
	}//main ends here
	
}//class ends here
