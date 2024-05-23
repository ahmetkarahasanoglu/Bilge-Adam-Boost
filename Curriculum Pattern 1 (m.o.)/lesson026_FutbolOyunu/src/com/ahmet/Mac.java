package com.ahmet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mac {
	
	long sure;
	List<Takim> takimlar;
	int[] macSkoru;
	Random random = new Random();
	
	
	// CONSTRUCTOR 1:
	public Mac() {
		this.takimlar = new ArrayList<>();
		macSkoru = new int[2];
		takimlar.add(new Takim("Ev Sahibi"));
		takimlar.add(new Takim("Deplasman"));
	}
	
	// CONSTRUCTOR 2:
	public Mac(int sure, List<Takim> takimlar) {
		this.takimlar = takimlar;
		this.sure = setSure(sure);
		macSkoru = new int[2];
	}
	
	// GETTERS AND SETTERS: -------
	public long getSure() {
		return sure;
	}

	public long setSure(long sure) { // we changed return type from 'void' to 'long'
		return  this.sure = sure + System.currentTimeMillis(); // We added current time's millisecond conversion to 'sure'
	}

	public List<Takim> getTakimlar() {
		return takimlar;
	}

	public void setTakimlar(List<Takim> takimlar) {
		this.takimlar = takimlar;
	}

	
	// METHODS: ------------
	public Takim oyna(Takim takim) throws InterruptedException {		
	    int idxPasAlan = generateIndexToReceivePass(12, takim); // to initiate with a random index.
	    int playerIndex = random.nextInt(takim.getFutbolcular().size());
	    boolean currentBasariliMi = false;	    
	    for(int i=0; i<3; i++) {
	        currentBasariliMi = takim.getFutbolcular().get(playerIndex).pasVer();	        
	        if (currentBasariliMi) {  // Eğer pas başarılıysa
	            idxPasAlan = generateIndexToReceivePass(playerIndex, takim);
	            System.out.println(takim.getIsim() + " takımından " + takim.getFutbolcular().get(playerIndex).getAdSoyad() + " isimli oyuncu " + takim.getFutbolcular().get(idxPasAlan).getAdSoyad() + " isimli oyuncuya pas verdi.");
	            playerIndex = idxPasAlan;	            
	            Thread.sleep(1500);
	        } else {
	            System.out.println(takim.getIsim() + " takımından " + takim.getFutbolcular().get(playerIndex).getAdSoyad() + " isimli oyuncunun pas girişimi başarısız.");
	            takim = takimDegistir(takim); // pasın başarısız olması durumunda top karşı takıma geçiyor.
	            playerIndex = generateIndexToReceivePass(playerIndex, takim); // pas başarısız oldu ve top karşı takıma geçecek; karşı takımda oyuna başlayacak oyuncunun, farklı index'te bir oyuncu olmasını sağlıyoruz. (sonsuz loop bug'ını çözmek için)
	            i = -1; // to reset 'i'. (will be '0' when beginning the next lap).
	        }	        
	    }
	    System.out.println(takim.getIsim() + " adlı takım gol vuruşu yapıyor...");
	    int kurtarisSkoru = kurtarisSkoruGetir(takim);
	    boolean golMu = takim.getFutbolcular().get(playerIndex).golVurusu(kurtarisSkoru);
	    if(golMu) {
	    	System.out.println("GOOOOOOOOOOOOOOOOOOOOLLLLLLLLLLLLLL");
	    	System.out.println(takim.getFutbolcular().get(playerIndex).getAdSoyad() + " adlı oyuncu golü atıyor !!!");
	    	macSkoruGuncelleGolAtanTakim(takim);
	    	macSkoruGoster();
	    } else {
	    	System.out.println("Gol vuruşu başarısız.");
	    	System.out.println(takim.getFutbolcular().get(playerIndex).getAdSoyad() + " adlı oyuncu golü kaçırıyor.");
	    }
	    return takim;
	}

	public Takim yaziTura() {
		Random random = new Random();
		int index = random.nextInt(0,2);		
		return takimlar.get(index);
	}
	
	public void mac() throws InterruptedException {
		System.out.println("Yazı tura atılıyor ve maça.....");
		Thread.sleep(1000);;
		Takim takim = yaziTura();
		System.out.println(takim.getIsim() + " takım başlıyor....");
		while(System.currentTimeMillis() < sure) {
			Takim golVurusuDeneyenTakim = oyna(takim);
			takim = takimDegistir(golVurusuDeneyenTakim); // bir tur oynandıktan sonra (gol vuruşu başarılı veya başarısız olduktan sonra) top karşı takıma geçiyor.
			System.out.println((sure - System.currentTimeMillis()) / 1000 + " saniye kaldı.");
		}
		System.out.println("------------------");
		System.out.println("Maç sona erdi.");
		macSkoruGoster();
	}

	public void macSkoruGoster() {		
		System.out.println("======= MAÇ SKORU: =======");
		System.out.println(takimlar.get(0).getIsim() + ": " + macSkoru[0] + " - " + macSkoru[1] + " :" + takimlar.get(1).getIsim());
		System.out.println("==========================");
	}

	public void macSkoruGuncelleGolAtanTakim(Takim takim) {
		int indexTakim = takimlar.indexOf(takim);
		macSkoru[indexTakim]++;		
	}

	public int generateIndexToReceivePass(int idxPassGiver, Takim takim) {		
		int idxPassReceiver;
		do {
			idxPassReceiver = random.nextInt(takim.getFutbolcular().size());
		}while(idxPassReceiver == idxPassGiver);
		return idxPassReceiver;
	}
	
	public Takim takimDegistir(Takim takim) {		
		if(takimlar.indexOf(takim) == 0) {			
			return takimlar.get(1);
		}else if(takimlar.indexOf(takim) == 1) {			
			return takimlar.get(0);
		}		
		return null;
	}
	
	public int kurtarisSkoruGetir(Takim currentTakim) {
		int idxCurTakim = takimlar.indexOf(currentTakim);
		int idxKarsiTakim = (idxCurTakim + 1) % 2;
		int karsiTakimKaleciKurtarisSkoru = takimlar.get(idxKarsiTakim).getKaleci().kurtarisSkoruHesapla();
		return karsiTakimKaleciKurtarisSkoru;
	}
	

}//CLASS ENDS HERE
