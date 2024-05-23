package com.ahmet.utility;

import java.util.ArrayList;
import java.util.List;

import com.ahmet.repository.entity.Musteri;
import com.ahmet.repository.entity.Satis;
import com.ahmet.repository.entity.Urun;

public class StaticValues {
	
//	public static Musteri[] musteriListesi = new Musteri[3]; // 'static' yaptık (uygulama ilk ayağa kalktığında çalışmaya başlayacak) 
//	public static Urun[] urunListesi = new Urun[3];		// '--> Ve 'public' yaptık; her yerden erişilebilsin diye.
//	public static Satis[] satisListesi = new Satis[3];
	
	public static int musteriCount = 0;
	public static int urunCount = 0;
	public static int satisCount = 0;  // bu count'lara ihtiyaç yok (ArrayList kullandığımız zaman)
	
	/*
	 * 'List interface' denen bir şey var Java'da.
	 * 1- Oluşturmak istediğiniz type'a göre liste oluşturur.
	 * 2- Generic type'a sahip bir interface'dir.
	 */
	public static List<Musteri> mList = new ArrayList<Musteri>();
	public static List<Urun> uList = new ArrayList<Urun>();
	public static List<Satis> sList = new ArrayList<Satis>();
	
}
