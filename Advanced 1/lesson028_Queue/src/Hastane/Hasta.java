package Hastane;
/*
 * isim
 * şikayet
 * öncelik özelliği
 * 
 * şikayete göre önceliği belirleyeceğiz.
 * 
 * Apandisit  -> en yüksek öncelik
 * Yanık	  -> Orta öncelik
 * Baş ağrısı -> En düşük öncelik
 * 
 * Önceliklere göre kuyruğu oluşturacağız.
 */
public class Hasta implements Comparable<Hasta> {

	private String isim;
	private String sikayet;
	private Integer oncelik;
	private static int count = 0;
	private int insertionOrder;
	
	// CONSTRUCTOR:
	public Hasta(String isim, String sikayet) {
		super();
		this.isim = isim;
		this.sikayet = sikayet;
		
		this.oncelik = oncelikBelirle(this.sikayet);
		this.insertionOrder = count++;
	}
	
	// METHODS: ---------
	public Integer oncelikBelirle(String sikayet) {
		Integer oncelikkkk = null;
		if(sikayet.equals("Apandisit")) {
			oncelikkkk = 1;
		}else if(sikayet.equals("Yanık")) {
			oncelikkkk = 2;
		}else if(sikayet.equals("Baş Ağrısı")) {
			oncelikkkk = 3;
		}
		return oncelikkkk;
	}

	@Override
	public String toString() {
		return "Hasta [isim=" + isim + ", sikayet=" + sikayet + ", oncelikOzelligi=" + oncelik + "]";
	}

	@Override
	public int compareTo(Hasta o) {
		if(o.oncelik < this.oncelik) {
			return 1;
		}else if(o.oncelik > this.oncelik) {
			return -1;
		}else {
			return Integer.compare(this.insertionOrder, o.insertionOrder);
		}		
	}
	
	
	
	
}
