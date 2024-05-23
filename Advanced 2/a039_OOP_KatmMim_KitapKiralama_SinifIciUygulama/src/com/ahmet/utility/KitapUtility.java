package com.ahmet.utility;

import java.util.ArrayList;
import java.util.List;

import com.ahmet.repository.entity.Kitap;

public class KitapUtility {
	
	static Long id = 0L;
	public static List<Kitap> kitapListesi = new ArrayList<>(); // Kitapları bu dizide saklayacağız.
	
	public static Long idOlustur() {
		return ++id;
	}
	
}
