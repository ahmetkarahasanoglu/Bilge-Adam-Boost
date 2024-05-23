package menu_odevi;

import java.util.ArrayList;
import java.util.Random;

public class Manager {
	
	static Random random = new Random();
	
	static ArrayList<Corba> corbaPool = new ArrayList<Corba>();
	static ArrayList<Icecek> icecekPool = new ArrayList<Icecek>();
	static ArrayList<Yemek> yemekPool = new ArrayList<Yemek>();
	static ArrayList<Tatli> tatliPool = new ArrayList<Tatli>();
	

	public static void main(String[] args) {		
		
		populatePoolsOfConsumables();
		
		ArrayList<Gun> gunler = createWeeklyProgram();
		printWeeklyProgram(gunler);		
		
		
	}//MAIN ENDS HERE --------
	
	public static void populatePoolsOfConsumables() {
		for(ECorba ecorba : ECorba.values()) {
			Corba corba = new Corba();
			corba.setAd(ecorba.name());
			corbaPool.add(corba);
		}
		for(EIcecek eicecek : EIcecek.values()) {
			Icecek icecek = new Icecek();
			icecek.setAd(eicecek.name());
			icecekPool.add(icecek);
		}
		for(EYemek eyemek : EYemek.values()) {
			Yemek yemek = new Yemek();
			yemek.setAd(eyemek.name());
			yemekPool.add(yemek);
		}
		for(ETatli etatli : ETatli.values()) {
			Tatli tatli = new Tatli();
			tatli.setAd(etatli.name());
			tatliPool.add(tatli);
		}
	}
	
	public static Menu createRandomMenu() {
		Menu menu = new Menu();		
		
		Corba corba = new Corba();
		int randomIndexCorba = random.nextInt(corbaPool.size());
		corba.setAd(corbaPool.get(randomIndexCorba).getAd());
		corbaPool.remove(randomIndexCorba);		
		menu.setCorba(corba);
		
		Icecek icecek = new Icecek();
		int randomIndexIcecek = random.nextInt(icecekPool.size());
		icecek.setAd(icecekPool.get(randomIndexIcecek).getAd());
		icecekPool.remove(randomIndexIcecek);
		menu.setIcecek(icecek);
		
		Yemek yemek = new Yemek();
		int randomIndexYemek = random.nextInt(yemekPool.size());
		yemek.setAd(yemekPool.get(randomIndexYemek).getAd());
		yemekPool.remove(randomIndexYemek);
		menu.setYemek(yemek);
		
		Tatli tatli = new Tatli();
		int randomIndexTatli = random.nextInt(tatliPool.size());
		tatli.setAd(tatliPool.get(randomIndexTatli).getAd());
		tatliPool.remove(randomIndexTatli);		
		menu.setTatli(tatli);
		
		return menu;		
	}
	
	public static ArrayList<Gun> createWeeklyProgram() {
		ArrayList<Gun> gunler = new ArrayList<Gun>();		
		for(EGun egun : EGun.values()) {
			Gun currentGun = new Gun();
			currentGun.setIsim(egun.name());
			gunler.add(currentGun);			
		}
		for(Gun gun : gunler) {
			gun.setMenu(createRandomMenu());
		}
		
		return gunler;
	}
	
	public static void printWeeklyProgram(ArrayList<Gun> gunler) {
		for(Gun gun : gunler) {
			System.out.println(gun.getIsim() + " --> " + gun.getMenu().toString());
		}
	}
	


}//CLASS ENDS HERE
