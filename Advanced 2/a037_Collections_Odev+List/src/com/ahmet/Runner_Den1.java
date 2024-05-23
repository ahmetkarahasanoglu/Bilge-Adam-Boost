package com.ahmet;

import java.util.Random;

public class Runner_Den1 {

	public static void main(String[] args) {
/*
 * ÖDEV: Bir dünya inşa edin.
 * Dünya -> Ülke -> Şehir -> İnsan  [iç içe listeler]
 *   şeklinde iç içe olsun. 20 ülke -> her ülkede  10 şehir olsun.
 * İnsanların 3 özelliği var -> yaş, cinsiyet, kilo (bunları 
 * random metoduyla belirleyebilirsiniz).
 * 100.000 insan oluşturup şehirlere rastgele atayın.
 * Uygulama işini bitirdiğinde, dünyada olan ülkeleri ve bu
 * ülkelerde  olan şehirleri ve şehirlerde olan insanları listeleyin
 * 
 * -> Örn:
 * A Ülkesi -> ABC şehrinde -> 400 insan yaşar ve çoğu yaşlı şişmandır.
 * B Ülkesi -> DEF şehrinde -> 20 insan yaşar ve çoğu çocuk ve kadındır.
 */
		
		Dunya dunya = new Dunya();
		
		for(int i=0; i<20; i++) {
			Ulke ulke = new Ulke();
			dunya.ulkeList.add(ulke);
			for(int j=0; j<10; j++) {
				Sehir sehir = new Sehir();
				dunya.ulkeList.get(i).sehirList.add(sehir);				
			}			
		}
		
		
		for(int i=0; i<100_000; i++) {
			Insan insan = new Insan();
			
			Random random = new Random();
			int randomNumber = random.nextInt(2);
			if(randomNumber == 0) {
				insan.cinsiyet = "Erkek";
			}else if(randomNumber == 1) {
				insan.cinsiyet = "Kadın";
			}
			
			int randomNumber2 = random.nextInt(100);
			insan.yas = randomNumber2;
			
			int randomNumber3 = random.nextInt(110);
			insan.kilo = randomNumber3;
			
			
			int ulkeRandomNum = random.nextInt(20);
			int sehirRandomNum = random.nextInt(10);
			
			dunya.ulkeList.get(ulkeRandomNum).sehirList.get(sehirRandomNum).insanList.add(insan);
		}
		
		
		
		// Yazdırmak için:
		System.out.println("Dünya......: " + dunya);
		for(int i=0; i<20; i++) {
			System.out.println("Ülke " + (i+1) + ": " + dunya.ulkeList.get(i));
			for(int j=0; j<10; j++) {
				System.out.println("Şehir " + (j+1) + ": " + dunya.ulkeList.get(i).sehirList.get(j));
				for(int k=0; k<dunya.ulkeList.get(i).sehirList.get(j).insanList.size(); k++) {
					System.out.println("İnsan " + (k+1) + ": " + dunya.ulkeList.get(i).sehirList.get(j).insanList.get(k).cinsiyet + " - " + dunya.ulkeList.get(i).sehirList.get(j).insanList.get(k).kilo + " kilo - " + dunya.ulkeList.get(i).sehirList.get(j).insanList.get(k).yas + " yaşında");					
				}
			}			
		}
		
		
		
		
		
		

	}//MAIN ENDS HERE ---------

}//CLASS ENDS HERE ---------
