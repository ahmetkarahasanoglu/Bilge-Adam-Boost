package com.ahmet.repository.entity;

import java.util.List;
import java.util.Map;

public class Ogrenci extends Kisi {

	EOgrenimDuzeyi ogrenimDuzeyi;
	List<KonuAnlasilmaDuzey> konuDuzeyListesi;  // Tüm konu düzeyleri bu şekilde bir arada tutulabilir. Bunu eklemek kolaydır. Ayrıştırmak ve analiz etmek nispeten zordur.
	Map<Ders, List<Konu>> dersListesi;  // Örneğin:  Key -> Java Dersi. Value -> [{id, konuAdı, tanım}, {id, konuAdı, tanım}].    Key -> C# Dersi. Value -> [{id, konuAdı, tanım}, {id, konuAdı, tanım}] 
//	Map<Ders, Map<Konu, KonuAnlasilmaDuzey>> dersListesiOrnek;  // Bu şekilde bir kullanım var (iç içe Map kullanımı). Ancak biraz karmaşık olduğu için tercih etmiyoruz.
	
	
	// GETTERS AND SETTERS:
	public EOgrenimDuzeyi getOgrenimDuzeyi() {
		return ogrenimDuzeyi;
	}
	public void setOgrenimDuzeyi(EOgrenimDuzeyi ogrenimDuzeyi) {
		this.ogrenimDuzeyi = ogrenimDuzeyi;
	}
	public List<KonuAnlasilmaDuzey> getKonuDuzeyListesi() {
		return konuDuzeyListesi;
	}
	public void setKonuDuzeyListesi(List<KonuAnlasilmaDuzey> konuDuzeyListesi) {
		this.konuDuzeyListesi = konuDuzeyListesi;
	}
	
	
	
}
