package com.ahmet.entity;

import java.util.UUID;

import com.ahmet.utility.StaticValues;

public class Urun {
	
	public long id = 0;
	public String uuid; // uuid kullanırsak bu şekilde.
	public String ad;
	public String marka;
	public String model;
	
	public Urun() {
		id = ++StaticValues.id; // başka bir sınıftan statik bir değişken olarak aldık ve her yeni ürün oluşturulduğunda 1 arttırarak kullandık.
		uuid = UUID.randomUUID().toString(); // uuid bu şekilde.
		
	}
	
}
