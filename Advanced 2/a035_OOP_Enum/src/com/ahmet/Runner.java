package com.ahmet;

import com.ahmet.entity.Cinsiyet;
import com.ahmet.entity.Personel;
import com.ahmet.entity.State;
import com.ahmet.entity.Yetki;
import com.ahmet.utility.Unvan;
import com.ahmet.utility.Unvan2;

public class Runner {

	public static void main(String[] args) {
		
//		Unvan unvan = new Unvan();  // KULLANILAMAZ, ENUM NEW'LENEMEZ.
		
		System.out.println("Enum Müdür......: " + Unvan.GenelMudur); // enum'u statik bir şeymiş gibi class üzerinden çağırırız.
		
		System.out.println(Unvan2.GenelMudur.getAd());
		System.out.println(Unvan2.GenelMudur.getNo());
		
		System.out.println(Unvan2.Hizmetli.getAd());
		System.out.println(Unvan2.Hizmetli.getNo());
		
		Unvan2 unvan2;
		unvan2 = Unvan2.KidemliPersonel;
		System.out.println(unvan2.getAd());
		System.out.println(unvan2.getNo());
		
		Personel personel = new Personel("Muhammet", 
										"Ankara", 
										"0555 666 77 88", 
										Unvan.Mudur, // 100 farklı ünvan olduğunu düşünelim. 
										State.Aktif, 
										Cinsiyet.Erkek, 
										Yetki.Admin);

		Personel personel2 = new Personel("Deniz", 
										"İzmir", 
										"0555 333 44 55", 
										Unvan.Muhendis, 
										State.Dondurulmus, 
										Cinsiyet.Kadin, 
										Yetki.Guest);


	}

}
