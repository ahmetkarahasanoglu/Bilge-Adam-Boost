package com.ahmet;

import java.util.UUID;

public class Kitap {
	String isim;
	Yazar yazar; // kurduğumuz düzende 1 kitabın 1 yazarı var.
	int sayfaSayisi;
	String isbnKodu = UUID.randomUUID().toString();
}
