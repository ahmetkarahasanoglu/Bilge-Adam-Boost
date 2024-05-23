package pckge;

public enum ErrorType {
	
	DOLU_YER_SECIMI(1001, "Seçtiğiniz yer doludur!"),
	SINIRLAR_DISINDA(1002, "Yaptığınız seçim sınırların dışındadır."),
	YETERSIZ_AGIRLIK(1003, "100 kilo altı bir yük yüklenemez!"),
	MESAI_GUNLERI_DISI(1004, "Cuma günü yük kabul edilmemektedir!"),
	GECERSIZ_KABUL_TARIHI(1005, "Geçmiş bir günün tarihini girdiniz!");
	
	
	private int code;
	private String message;	
	
	// CONSTRUCTOR:
	private ErrorType(int code, String message) {
		this.message = message;
		this.code = code;
	}

	// GETTERS:
	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}
	
	
	

	
}
