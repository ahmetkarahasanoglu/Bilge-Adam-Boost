package dependencyInversion;

import utility.Bildirim;
import utility.Kullanici;
/**
 * Interface Segregation -> Sorumlulukların hepsini tek bir interface'e
 * 							yüklememek gerekir.
 * Sorun: twitter hikaye paylaşma özelliğini desteklemiyor, 
 * o yüzden bir hata meydana geliyor, bunu nasıl çözeriz?
 * 
 */
public class Instagram extends SosyalMedya implements IEmailSendable, ISmsSendable, IPostable, IStory {

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

	@Override
	public void postGonder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sohbetEt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resimPaylas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void smsGonder(Kullanici kullanici) {
		if(kullanici.getPhone() != null) {
			Bildirim.smsGonder(kullanici.getPhone());
		}
		
	}

	@Override
	public void emailGonder(Kullanici kullanici) {
		if(kullanici.getEmail() != null) {
			Bildirim.emailGonder(kullanici.getEmail());
		}
		
	}

	@Override
	public void hikayePaylas() {
		// TODO Auto-generated method stub
		
	}
	
	// --- Bu metot "single responsibility" prensibine uyumuyor. Bunu iptal edip ayrı ayrı metotlar yazacağız.
//	public void bildirimGonder(Kullanici kullanici) {
//		if(kullanici.getPhone() != null) {
//			Bildirim.smsGonder(kullanici.getPhone());
//		}
//		if(kullanici.getEmail() != null) {
//			Bildirim.emailGonder(kullanici.getEmail());
//		}
//	}
	
	// --- smsGonder ve emailGonder metotları oluşturduk. Daha sonra bunları bir üst sınıfta (SosyalMedya sınıfı) topladık. Bu sınıfta da SosyalMedya sınıfını miras aldık.
//	public void smsGonder(Kullanici kullanici) {
//		if(kullanici.getPhone() != null) {
//			Bildirim.smsGonder(kullanici.getPhone());
//		}
//	}
//	
//	public void emailGonder(Kullanici kullanici) {
//		if(kullanici.getEmail() != null) {
//			Bildirim.emailGonder(kullanici.getEmail());
//		}
//	}
	
	
	
	
	
}
