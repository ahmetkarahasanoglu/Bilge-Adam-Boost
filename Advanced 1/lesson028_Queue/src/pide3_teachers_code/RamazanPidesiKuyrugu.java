package pide3_teachers_code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * String bir kuyruk tanımlayacağız.
 * Bu kuyruğa 10-12 tane isim ekleyeceğiz.
 * Random 1-10 arası sayı üreteceğiz (pide sayımız olcak bu).
 * Kuyruğa göre pideleri dağıtacağız.
 * Pide bittiğinde "Pide bitti" yazdıracağız.
 * Bir de pide alamayanları yazdıralım.
 */
public class RamazanPidesiKuyrugu {

	Queue<String> kuyruk = new LinkedList<>();

	public RamazanPidesiKuyrugu() {
		kuyrukOlustur();
	}

	public static void main(String[] args) throws InterruptedException {
		RamazanPidesiKuyrugu ramazanPidesiKuyrugu = new RamazanPidesiKuyrugu();
		ramazanPidesiKuyrugu.pideDagıt();
		ramazanPidesiKuyrugu.geriyeKalanlar();

	}

	public void kuyrukOlustur() {
		kuyruk.offer("Ahmet");
		kuyruk.offer("Murat");
		kuyruk.offer("Hasan");
		kuyruk.offer("Ozan");
		kuyruk.offer("Zeliha");
		kuyruk.offer("Sümeyye");
		kuyruk.offer("Ezgi");
		kuyruk.offer("Gizem");
		kuyruk.offer("Oguz");
		kuyruk.offer("Attilla");
		kuyruk.offer("Mustafa");

	}

	public void pideDagıt() throws InterruptedException {
		Random random = new Random();
		int pideSayisi = random.nextInt(10) + 1;
		System.out.println("Pideler Cıkıyor");
		System.out.println("Pide sayısı= " + pideSayisi);
		Thread.sleep(2000);

		for (int i = 0; i < pideSayisi; i++) {
			if (!kuyruk.isEmpty()) {
				System.out.println(kuyruk.poll() + " pidesini aldı");
			}
		}

	}

	public void geriyeKalanlar() {
		if (kuyruk.isEmpty()) {
			System.out.println("Pidesini almayan musteri kalmadı");

		} else {
			System.out.println("Pide bitti pide alamayanlar:");
			kuyruk.forEach(System.out::println);
		}

	}

}
