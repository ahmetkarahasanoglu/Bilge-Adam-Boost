package menu_odevi;
/*
 * Menu diye bir sınıfımız olacak
 * Corbalar, Içecekler, Yemekler ve Tatlıların tutulduğu. Her
 * biri için bir Enum oluşturacağız.
 * İçecek sayımız 7 olsun.
 * Menü sınıfı içinde kullanacağız.
 * Günlerimiz olacak, bunu da bir enum yapabilirsiniz.
 * Manager sınıfımızda her gune random bir menu belirleyeceğiz.
 * Her gün random bir çorba, içecek, yemek ve tatlı. -> sırayla
 * pazartesiden pazara olsun.
 * Manager sınıfında haftalık menü yazdırılsın.
 *Öncelikle, farklı günlerde aynı değerler çıkabilecek şekilde
 *yaparsınız, sonra
 * Extra özellik olarak:
 * İçeceklerimiz her güne sadece bir içecek gelecek şekilde 
 * (haftanın bir günü kola geldiyse ikinci defa kola gelmesin)
 *
 */
public class Menu {
	
	private Corba corba;
	private Icecek icecek;
	private Yemek yemek;
	private Tatli tatli;
	
	
	// CONSTRUCTOR 1:
	public Menu() {
		
	}

	// CONSTRUCTOR 2:
	public Menu(Corba corba, Icecek icecek, Yemek yemek, Tatli tatli) {
		super();
		this.corba = corba;
		this.icecek = icecek;
		this.yemek = yemek;
		this.tatli = tatli;
	}

	// GETTERS AND SETTERS:
	public Corba getCorba() {
		return corba;
	}

	public void setCorba(Corba corba) {
		this.corba = corba;
	}

	public Icecek getIcecek() {
		return icecek;
	}

	public void setIcecek(Icecek icecek) {
		this.icecek = icecek;
	}

	public Yemek getYemek() {
		return yemek;
	}

	public void setYemek(Yemek yemek) {
		this.yemek = yemek;
	}

	public Tatli getTatli() {
		return tatli;
	}

	public void setTatli(Tatli tatli) {
		this.tatli = tatli;
	}

	
	// METHODS:
	@Override
	public String toString() {
		return "Menu [corba=" + corba.getAd() + ", icecek=" + icecek.getAd() + ", yemek=" + yemek.getAd() + ", tatli=" + tatli.getAd() + "]";
	}

	
	
}
