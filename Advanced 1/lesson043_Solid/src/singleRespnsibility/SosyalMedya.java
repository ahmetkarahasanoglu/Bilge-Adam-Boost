package singleRespnsibility;

import utility.Bildirim;
import utility.Kullanici;

public class SosyalMedya {

	// --- Bu metot "single responsibility" prensibine uyumuyor. Bunu iptal edip ayrı ayrı metotlar yazacağız.
//	public void bildirimGonder(Kullanici kullanici) {
//		if(kullanici.getPhone() != null) {
//			Bildirim.smsGonder(kullanici.getPhone());
//		}
//		if(kullanici.getEmail() != null) {
//			Bildirim.emailGonder(kullanici.getEmail());
//		}
//	}

	public void smsGonder(Kullanici kullanici) {
		if(kullanici.getPhone() != null) {
			Bildirim.smsGonder(kullanici.getPhone());
		}
	}
	
	public void emailGonder(Kullanici kullanici) {
		if(kullanici.getEmail() != null) {
			Bildirim.emailGonder(kullanici.getEmail());
		}
	}
	
}
