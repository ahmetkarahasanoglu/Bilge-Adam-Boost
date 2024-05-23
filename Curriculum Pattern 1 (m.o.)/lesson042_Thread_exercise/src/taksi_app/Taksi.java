package taksi_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Taksilerimizin her biri bir thread olacak.
 * Taksilerde: id, musterisayısı, musterilerin id'sinin tutulduğu
 * bir liste, bekleme süresi(random long bir değer oluşturalım
 * 1000 - 5000 arasında olsun).
 * Durağımızda taksilerimiz olsun.
 * Durağımızda bir müşteri kuyruğumuz olacak, bu kuyrukta 
 * müşterilerimizin id'si tutulacak.
 * Kuyruğumuzda 100 tane müşteri olsun.
 * Durağımızda da 10 tane taksimiz olsun.
 * Kuyruğumuz boşalana kadar taksilerimiz sıra ile kuyruğumuzdan
 * müşterileri alsın.
 * Kuyruktan aldığı müşteri no'sunu kendi içinde tuttuğu listeye
 * eklesin.
 * 1.nolu taksi 5.müşterisini aldı --> musteri id'si --> 8 diye
 * yazdırsın.
 * Daha sonra taksimiz bekleme süresi kadar bekleyip  döngümüze
 * devam etsin. Döngümüz sona erdiğinde:
 * 1 nolu taksi toplamda -> 20 müşteri aldı ve mesaisi sona erdi.
 */
public class Taksi implements Runnable {

	private long id;
	private static long idForNewInstance = 0;
	private int musteriSayisi;
	private List<Long> musterilerinIDleri = new ArrayList<>();
	private long beklemeSuresi;
	
	// CONSTRUCTOR: 
	public Taksi() {
		this.id = ++idForNewInstance;
		Random random = new Random();
		this.beklemeSuresi = random.nextLong(1000, 5001);
	}

	// GETTERS:
	public long getId() {
		return id;
	}
	
	public static long getIdForNewInstance() {
		return idForNewInstance;
	}
	
	public int getMusteriSayisi() {
		return musteriSayisi;
	}
	
	public List<Long> getMusterilerinIDleri() {
		return musterilerinIDleri;
	}

	public long getBeklemeSuresi() {
		return beklemeSuresi;
	}


	@Override
	public void run() {
		while(!Durak.getMusteriIDleriKuyrugu().isEmpty()) {
			long currentMusteriID = Durak.getMusteriIDleriKuyrugu().poll();
			this.musterilerinIDleri.add(currentMusteriID);
			musteriSayisi++;
			System.out.println(this.id + " id'li taksi " + musteriSayisi + ". müşterisini aldı. Müşteri ID'si: " + currentMusteriID);
			try {
				Thread.sleep(this.getBeklemeSuresi());
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.println(this.id + " id'li taksi toplamda " + musteriSayisi + " musteri aldı ve mesaisi sona erdi.");
		
	}

}
