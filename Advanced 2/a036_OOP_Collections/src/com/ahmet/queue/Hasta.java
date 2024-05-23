package com.ahmet.queue;

public class Hasta implements Comparable<Hasta> { // Hastaların öncelik sırasının belirlenebilmesi için(RunnerHastaPriorityQueue class'ında) burda Comparable Interface'ini implement ettik(içine Hasta class'ını verdik [generic type in interface]; yazılması zorunlu olan compareTo metodunu implement etmiş olduk. 
	
	private String ad;
	private String tcno;
	private int yas;
	
	
	//CONSTRUCTOR:
	public Hasta(String ad, String tcno, int yas) {
		super();
		this.ad = ad;
		this.tcno = tcno;
		this.yas = yas;		
	}

	// GETTERS AND SETTERS:
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	// METHODS: -------
	@Override
	public String toString() {
		return "Hasta [ad=" + ad + ", tcno=" + tcno + ", yas=" + yas + "]";
	}

	@Override
	public int compareTo(Hasta o) {  // Comparable Interface'inden.
//		if(o.getYas()<=7 || o.getYas()>= 65) {
//			return 1;
//		}
//		return -1;
		
		// - CHAT GPT's code -:
		// First, check if one patient's age meets the priority criteria and the other doesn't
	    boolean thisIsPriority = this.getYas() <= 7 || this.getYas() >= 65;
	    boolean otherIsPriority = o.getYas() <= 7 || o.getYas() >= 65;

	    if (thisIsPriority && !otherIsPriority) {
	        return -1; // This patient is a priority
	    } else if (!thisIsPriority && otherIsPriority) {
	        return 1; // Other patient is a priority
	    }

	    // If both or neither are priority based on age, prioritize based on arrival order
	    // Patients with lower index (added earlier) get higher priority in case of a tie
	    return 0;
	}	
	
	
	
}
