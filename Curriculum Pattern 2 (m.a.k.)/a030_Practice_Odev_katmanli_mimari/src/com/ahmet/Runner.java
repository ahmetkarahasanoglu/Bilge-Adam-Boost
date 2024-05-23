package com.ahmet;

import com.ahmet.controller.HastaController;

/*
 * Entity'miz 'Hasta'. Hasta'nın ID'si, hasta numarası, adıSoyadı, hastalığı olacak.
 * Repository sınıfında kaydet ve listele olsun. Service'de ve Controller'da
 * da aynı şekilde.
 */
public class Runner {

	public static void main(String[] args) {
		HastaController controller = new HastaController();
		controller.HastaKaydet();
		controller.HastaKaydet();
		controller.HastaListesiGöster();

	}

}
