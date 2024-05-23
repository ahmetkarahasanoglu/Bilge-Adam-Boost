package menu_odevinin_cozumu;

public enum EIcecekler {

	AYRAN(false), KOLA(false), FANTA(false), GAZOZ(false), MEYVESUYU(false), LİMONATA(false), ICETEA(false);

	boolean atandimi; // We're using 'atandimi' to make sure that once an item is used, it won't be used again.

	// CONSTRUCTOR:    - (Enum'da constructor kullanımı)
	EIcecekler(boolean atandimi) {
		this.atandimi = atandimi;
	}

	// GETTERS AND SETTERS:
	public boolean isAtandimi() {
		return atandimi;
	}

	public void setAtandimi(boolean atandimi) {
		this.atandimi = atandimi;
	}

}
