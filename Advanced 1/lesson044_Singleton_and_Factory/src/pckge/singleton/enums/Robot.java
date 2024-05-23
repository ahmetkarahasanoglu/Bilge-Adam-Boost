package pckge.singleton.enums;
/**
 * Enums tekniğiyle Singleton Pattern
 * 
 */
public enum Robot {
	
	ROBOT;
	
	public void calis() {
		System.out.println(this.hashCode() + " robot çalışıyor.");
	}
}
