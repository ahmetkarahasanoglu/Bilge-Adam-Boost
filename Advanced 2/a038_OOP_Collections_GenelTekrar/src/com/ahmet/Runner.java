package com.ahmet;

import java.util.Arrays;
import java.util.List;

import com.ahmet.repository.entity.Ders;
import com.ahmet.repository.entity.ECinsiyet;
import com.ahmet.repository.entity.EKonuDuzey;
import com.ahmet.repository.entity.EOgrenimDuzeyi;
import com.ahmet.repository.entity.Konu;
import com.ahmet.repository.entity.KonuAnlasilmaDuzey;
import com.ahmet.repository.entity.Ogrenci;

public class Runner {

	public static void main(String[] args) {
		
		Ders ders = new Ders("Java");
		Ders ders2 = new Ders("C#");
		
		Konu kj1 = new Konu(null, "Değişkenler", ders); // (kj1: konujava1 anlamında) 
		Konu kj2 = new Konu(null, "Döngüler", ders);
		Konu kj3 = new Konu(null, "Koşullar", ders);
		Konu kj4 = new Konu(null, "Operatörler", ders);
		
		Konu kd1 = new Konu(null, "Mvc", ders2); // (kd1: konudatnet1 anlamında)
		Konu kd2 = new Konu(null, "Blazor", ders2);
		Konu kd3 = new Konu(null, "EntityFramework", ders2);

		KonuAnlasilmaDuzey kad = new KonuAnlasilmaDuzey(kj1, EKonuDuzey.IYI, 125, 96, 76);
		KonuAnlasilmaDuzey kad1 = new KonuAnlasilmaDuzey(kj2, EKonuDuzey.ORTA, 200, 175, 88);
		KonuAnlasilmaDuzey kad2 = new KonuAnlasilmaDuzey(kj3, EKonuDuzey.IYI, 205, 204, 99);
		KonuAnlasilmaDuzey kad3 = new KonuAnlasilmaDuzey(kj4, EKonuDuzey.ORTA, 177, 160, 82);
		
		List<KonuAnlasilmaDuzey> kadList = Arrays.asList(kad, kad1, kad2, kad3);
		
		Ogrenci ogr = new Ogrenci();
		ogr.setActive(true);
		ogr.setAd("Ahmet");
		ogr.setAdres("Ankara");
		ogr.setCinsiyet(ECinsiyet.ERKEK);
		ogr.setTelefon("0 555 666 77 88");
		ogr.setYas(35);
		ogr.setKonuDuzeyListesi(kadList); // yukarda oluşturduğumuz kadList'i verdik buraya.
		ogr.setOgrenimDuzeyi(EOgrenimDuzeyi.IYI_BILIYOR);
			
		System.out.println("Öğrenci....: " + ogr.getAd());
		ogr.getKonuDuzeyListesi().forEach(x->{			
			System.out.print("Konu adı...:" + x.getKonu().getAd());
			System.out.print(" - Yüzde...: " + x.getYuzde() + "%");
			System.out.println();
		});
		
		// Yukarıda yaptığımız gibi verileri iç içe tutmak büyük 
		// uygulamalarda verimli değildir, RAM'i şişirir.
		
		
	}//MAIN ENDS HERE ---------

}//CLASS ENDS HERE -------
