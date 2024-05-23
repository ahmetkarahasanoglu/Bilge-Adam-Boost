package com.ahmet;

public class StaticValues {
/*
 * When we write a software, creating lots of object is bad in terms of
 * RAM usage. It slows down the app. So, we can use 'static' when
 * appropriate; to keep our app fast.
 * 
 * But we shouldn't define everything as 'static'. Because static values
 * have a place in memory as soon as the app starts; so there would be
 * a lot of occupied memory when the app starts.
 */
	public static String webpage = "https://www.bizimuygulama.com.tr";
	public static String programName = "Yeni Program";
	public static String versionNumber = "V.0.0.1";
	public static String owner = "Ahmet Kara";
}
