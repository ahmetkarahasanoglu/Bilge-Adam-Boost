package com.ahmet.list;

public class Runner_genelFikir {

	public static void main(String[] args) {
// İstediğim herhangi bir class ile MyList'i kullanabiliyorum (generic type kullandığından dolayı)
		MyList<Ogrenci> ogrenciListesi = new MyList<Ogrenci>();
		Ogrenci ogr = new Ogrenci();
		ogr.ad = "Muhammet";
		ogrenciListesi.add(ogr);
		
		MyList<Urun> urunListesi = new MyList<Urun>();
		Urun urun = new Urun();
		urunListesi.add(urun);
		
		
	}//main ends here
	
}//class ends here
