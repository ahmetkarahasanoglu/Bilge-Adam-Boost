package openClosed;

import utility.Bildirim;
import utility.Kullanici;

public class Facebook extends SosyalMedya {

	@Override
	public void boyutlandirma(String fileType) {
		if(fileType.equalsIgnoreCase("jpg")) {
			setKucultmeKatsayisi(34.0);
		}else if(fileType.equalsIgnoreCase("png")) {
			setKucultmeKatsayisi(37.0);
		}else {
			setKucultmeKatsayisi(45);
		}	
		
	}
	
// --- Bu metot "single responsibility" prensibine uyumuyor. Bunu iptal edip ayrı ayrı metotlar yazacağız.
//		public void bildirimGonder(Kullanici kullanici) {
//			if(kullanici.getPhone() != null) {
//				Bildirim.smsGonder(kullanici.getPhone());
//			}
//			if(kullanici.getEmail() != null) {
//				Bildirim.emailGonder(kullanici.getEmail());
//			}
//		}
	
	// --- smsGonder ve emailGonder metotları oluşturduk. Daha sonra bunları bir üst sınıfta (SosyalMedya sınıfı) topladık. Bu sınıfta da SosyalMedya sınıfını miras aldık.
//		public void smsGonder(Kullanici kullanici) {
//			if(kullanici.getPhone() != null) {
//				Bildirim.smsGonder(kullanici.getPhone());
//			}
//		}
//	
//		public void emailGonder(Kullanici kullanici) {
//			if(kullanici.getEmail() != null) {
//				Bildirim.emailGonder(kullanici.getEmail());
//			}
//		}
	
}
