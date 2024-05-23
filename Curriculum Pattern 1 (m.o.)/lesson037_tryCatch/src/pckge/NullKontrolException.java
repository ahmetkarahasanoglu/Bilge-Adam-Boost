package pckge;
// extends Exception --> checked exception'dır.
// extends RuntimeException --> unchecked exception'dır.
public class NullKontrolException extends RuntimeException { // -> Unchecked exception
		
	String mesaj;

	// CONSTRUCTOR:
	public NullKontrolException(String mesaj) {
		super();
		this.mesaj = mesaj;
	}

	// GETTERS AND SETTERS:
	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	
	
	
	
}
