package com.ahmet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class String11_WebsiteURL_Burclar {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.out.println("*******************************");
		System.out.println("**********  GÜNLÜK  ***********");
		System.out.println("*******  BURÇ YORUMU  ********");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Burcunuzu seçiniz: ");
		System.out.println("1) Koç");
		System.out.println("2) Boğa");
		System.out.println("3) İkizler");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		String myUrl = "https://www.elle.com.tr/astroloji/";
		switch(choice) {
			case 1: 
				myUrl = myUrl.concat("koc"); 
				break;
			case 2: 
				myUrl = myUrl.concat("boga"); 
				break;
			case 3: 
				myUrl = myUrl.concat("ikizler"); 
				break;
			default: 
				myUrl = myUrl.concat("koc"); 
		}
		
		sc.close();
		Scanner siteScan = new Scanner(new URL(myUrl).openStream(), "UTF-8");		
		while(siteScan.hasNext()) { // means: as long as there is a next line that can be read			
			String line = siteScan.nextLine();			
			line = line.replace("<br>", "");
			line = line.replace("&rsquo;", "'");
			if(line.contains("<p>") || line.contains("</p>")) {
				line = line.replace("<p>", "");
				line = line.replace("</p>", "");
				if(!line.isEmpty()) {
					System.out.println(line);
				}					
			}						
		}
		
		
		
	}
}
