package com.ahmet;

import java.util.Random;

public class StaticValues {

	static Random random = new Random();
	
	private static int formaNoDefans = 1;
	private static int formaNoOrtaSaha = 5;
	private static int formaNoForvet = 9;
	
	private static int seqNumDefans = 0;
	private static int seqNumOrtaSaha = 0;
	private static int seqNumForvet = 0;
	
	
	public static int generateRandomValue(int min, int max) {  // min and max both inclusive
		int result = random.nextInt(max - min + 1) + min;
		return result;
	}
	
	
	public static int generateSeqNumDefans() {
		seqNumDefans++;
		return seqNumDefans;
	}
	public static int generateSeqNumOrtaSaha() {
		seqNumOrtaSaha++;
		return seqNumOrtaSaha;
	}
	public static int generateSeqNumForvet() {
		seqNumForvet++;
		return seqNumForvet;
	}
	
	
	public static int generateFormaNoDefans() {
		formaNoDefans++;
		return formaNoDefans;
	}
	public static int generateFormaNoOrtaSaha() {
		formaNoOrtaSaha++;
		return formaNoOrtaSaha;
	}
	public static int generateFormaNoForvet() {
		formaNoForvet++;
		return formaNoForvet;
	}
	
}
