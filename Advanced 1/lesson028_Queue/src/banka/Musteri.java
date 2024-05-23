package banka;

public class Musteri implements Comparable<Musteri> {

	String ad;
	int yas;
	private static int count = 0;
	private int insertionOrder;
		
	
	// CONSTRUCTOR:
	public Musteri(String ad, int yas) {
		super();
		this.ad = ad;
		this.yas = yas;
		this.insertionOrder = count++;
	}

	

	@Override
	public String toString() {
		return "Musteri [ad=" + ad + ", yas=" + yas + "]";
	}

	@Override
	public int compareTo(Musteri o) {
//		if(o.yas >= 65) {
//			return 1;
//		}
//		return -1;
		
		//--- Chat Gpt's ---
		if (this.yas >= 65 && o.yas < 65) {
	        // This customer is above 65, give it higher priority
	        return -1;
	    } else if (this.yas < 65 && o.yas >= 65) {
	        // Other customer is above 65, give it higher priority
	        return 1;
	    } else {
	        // Both customers are either above 65 or below 65, maintain the order of insertion
	        return Integer.compare(this.insertionOrder, o.insertionOrder);
	    }
	}
	
	
}