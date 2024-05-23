package pckge.factory2;

public class PizzaFactory {
/**
 * 1- etli pizza
 * 2- vejeteryan pizza
 */
	public static Pizza createPizza(ETur tur, EBoyut boyut, EHamurTipi hamurTipi) {
		switch(tur) {
		case TONBALIKLI, KARISIK:
			return new EtliPizza(tur, boyut, hamurTipi);
		case AKDENIZ:
			return new VejeteryanPizza(tur, boyut, hamurTipi); 
		default:
			throw new RuntimeException("Geçersiz pizza tipi girişi yaptınız.");
		}
	}
}
