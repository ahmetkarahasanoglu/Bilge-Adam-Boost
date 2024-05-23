package openClosed;

import utility.Bildirim;
import utility.Kullanici;
/**
 * Open / Closed Prensibi: Kodlarımız geliştirmeye açık,
 * değiştirmeye kapalı olmalı.
 * 
 * Resim boyutlandırma sınıfına bir metot yazacaz. Bu metot
 * bizden bir instagram'ı alacak ve bir String type alacak. Eğer
 * jpg ise küçültme katsayisi 38, png ise 30 olsun.
 * 
 * Yeni bir sosyal medya uygulaması daha eklendi ve facebook'un
 * jpg küçültme katsayısı 34, png 37 olsun, diğer 45.
 * 
 * Whatsapp sosyal medya uygulaması ekledik. jpg 28, png 32,
 * diğerleri 36. Sorunumuz her sosyal medya eklendiğinde
 * ResimBoyutlandirma'daki boyutlandirma2 metoduna yeni 
 * if-else'ler eklemek zorunda kalıyoruz. Bunu gidermek için
 * ne yapabiliriz?
 * '--> Çözüm: Sosyal medya class'ında bir abstract metot
 * oluşturduk 'boyutlandirma()'. Her sınıf kendi özelinde 
 * boyutlandırma değerlerini setledi ve daha sonra resim
 * boyutlandırma sınıfındaki boyutlandırma metodunda 
 * sosyalMedya abstract sınfı üzerinden kalıtım yapısı ile
 * beraber abstract metot çağırıldı ve test sınıfında 3 farklı
 * sınıf oluşturularak bu tek metot ile çalıştırıldı. Daha
 * sonra bir sosyal medyaya daha ihtiyaç duyarsak 
 * ResimBoyutlandirma sınıfındaki boyutlandırma metodunu 
 * değiştirmeden kullanılabilecek bir hale getirmiş olduk.
 */
public class Instagram extends SosyalMedya {

	@Override
	public void boyutlandirma(String fileType) {
		if(fileType.equalsIgnoreCase("jpg")) {
			setKucultmeKatsayisi(38.0);
		} else if(fileType.equalsIgnoreCase("png")) {
			setKucultmeKatsayisi(30.0);
		}else {
			setKucultmeKatsayisi(40);
		}		
		
	}
	
	
	
	
	
}
