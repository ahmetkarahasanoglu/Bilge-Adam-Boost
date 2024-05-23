package pckge.factory2;

public class PizzaSiparis {
	/**
	 * 
	 * pizzam�z�n hamur tipini .boyutunu ve turunu secip bize bir pizza olarak d�nen
	 * metodu yazal�m ve pizzay� yazd�ral�m
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(hamurTipiSec());

		// DI�ardan girilen string de�re g�re bize enumun degerini donuyor
		// System.out.println(EHamurTipi.valueOf("INCE"));

		// System.out.println(hamurTipiSec2("INCE"));

//		System.out.println(EHamurTipi.KALIN.name());
//		System.out.println(EHamurTipi.NORMAL.ordinal());
//		System.out.println(EHamurTipi.KALIN.toString());

//		EHamurTipi[] hamurtipleri = EHamurTipi.values();
//
//		for (EHamurTipi tip : hamurtipleri) {
//
//			System.out.println(tip);
//		}
		PizzaSiparis pizzaSiparis = new PizzaSiparis();
		Pizza pizza = pizzaSiparis.pizzaSec();
		System.out.println(pizza);
		System.out.println(pizza.getClass());
		
	}//MAIN ENDS HERE -----

	public void menu() {
		System.out.println("Pizza Sipari� Menusu");
		Pizza pizza = pizzaSec();
		siparisHazirlama(pizza);
	}

	public Pizza pizzaSec() {
		ETur tur = turSec();
		EBoyut boyut = boyutuSec();
		EHamurTipi hamurTipi = hamurTipiSec();		
		Pizza pizza = PizzaFactory.createPizza(tur, boyut, hamurTipi);
		return pizza;
	}

	public void siparisHazirlama(Pizza pizza) {
		System.out.println("Siparis�iniz ==>" + pizza.toString());
		System.out.println("Haz�rlan�yor .....");
	}

	public ETur turSec() {
		for (ETur tur : ETur.values()) {
			System.out.println((tur.ordinal() + 1) + "-" + tur);
		}
		int secim = Utility.intDegerAlma("L�tfen bir pizza t�r� seciniz");

		switch (secim) {
		case 1:
			return ETur.TONBALIKLI;
		case 2:
			return ETur.KARISIK;
		case 3:
			return ETur.AKDENIZ;
		default:
			return null;
		}

	}

	public EBoyut boyutuSec() {
		for (EBoyut boyut : EBoyut.values()) {
			System.out.println((boyut.ordinal() + 1) + "-" + boyut);// 1- KUCUK 2-Orta 3-buyuk
		}

		int secim = Utility.intDegerAlma("L�tfen Pizza boyutunu seciniz");
//		switch (secim) {
//		case 1:
//			return EBoyut.KUCUK;
//		case 2:
//			return EBoyut.ORTA;
//		case 3:
//			return EBoyut.BUYUK;
//		default:
//			return null;
//		}

		return EBoyut.values()[secim - 1];

	}

	public EHamurTipi hamurTipiSec() {
		for (EHamurTipi tip : EHamurTipi.values()) {
			System.out.println((tip.ordinal() + 1) + "-" + tip);
		}

		int secim = Utility.intDegerAlma("L�tfen Hamur Tipi Secimi");

		switch (secim) {
		case 1:
			return EHamurTipi.INCE;
		case 2:
			return EHamurTipi.NORMAL;
		case 3:
			return EHamurTipi.KALIN;
		default:
			return null;
		}

	}

}
