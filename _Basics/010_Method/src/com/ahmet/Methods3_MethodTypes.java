package com.ahmet;

public class Methods3_MethodTypes {

	public static void main(String[] args) {
		
		boolean isInternetAvailable = isThereInternetConnection();
		if(isInternetAvailable) {
			System.out.println("Internet available. App has opened.");
		}else {
			System.err.println("No internet. Check your internet connection.");
		}
		
		double result = dikdortgenIslemiYap(4,6,"alan");
		System.out.println(result);

	}//main sonu
	
	// METHODS THAT RETURNS SOMETHING
	public static boolean isThereInternetConnection() {
		// code
		return false;
	}
	// Geometrik işlem yapalım:
	public static double dikdortgenIslemiYap(int genislik, int yukseklik, String islem) {
		switch(islem) {
		case "cevre":
			return (double)2*(genislik+yukseklik); // since we used 'return', no need to use 'break'.
		case "alan":
			return genislik*yukseklik;
		}
		return 0;
		
	}
}// class sonu
