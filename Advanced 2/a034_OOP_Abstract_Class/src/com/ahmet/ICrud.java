package com.ahmet;

public interface ICrud {
/*
 * - Interface'lerin içinde erişim belirteci (access modifier)
 * kullanmıyoruz.
 * - Interface'lerde metotların gövdeleri yoktur.
 * - Interface'ler new yapılarak nesne oluşturmazlar. Yani main metodundayken şöyle yazamayız:  ICrud crud = new ICrud()  --> yazamayız. YANLIŞTIR.
 */
	
	void save();
	void update();
	void delete(Long id);
	
	void findById(Long id);
}
