package com.ahmet;

import com.ahmet.entity.Hizmetli;
import com.ahmet.entity.Mudur;
import com.ahmet.entity.Muhendis;

public class Runner {

	public static void main(String[] args) {
		
		Muhendis muhendis = new Muhendis();
		Mudur mudur = new Mudur();
		Hizmetli hizmetli = new Hizmetli();
		
		muhendis.ad = "Ali";
		mudur.ad = "Tekin";
		hizmetli.ad = "Burhan";
		muhendis.telefon = "444 444 444";
		

	}//main ends here

}//class ends here
