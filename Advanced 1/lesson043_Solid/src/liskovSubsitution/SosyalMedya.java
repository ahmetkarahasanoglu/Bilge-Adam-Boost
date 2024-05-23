package liskovSubsitution;

import utility.Bildirim;
import utility.Kullanici;

public abstract class SosyalMedya implements ISocialMedia { // ISocialMedia metotlarının implementansyonunu Facebook, Instagram ve Whatsap sınıflarında yapacağız. (Burda yapmıyoruz) [Aslında bu metotları burda abstract metot olarak implement edersem(gövdesiz olarak) bi etkisi olmaz; zaten facebook, instagram gibi sınıflarda implement ediyoruz[2 üst interface'den dolaylı şekilde implement etmiş oluyoruz]) 

	// --- Bu metot "single responsibility" prensibine uyumuyor. Bunu iptal edip ayrı ayrı metotlar yazacağız.
//	public void bildirimGonder(Kullanici kullanici) {
//		if(kullanici.getPhone() != null) {
//			Bildirim.smsGonder(kullanici.getPhone());
//		}
//		if(kullanici.getEmail() != null) {
//			Bildirim.emailGonder(kullanici.getEmail());
//		}
//	}

	// --- sms ve email göndermek için ayrı ayrı metotlar yazımı:
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
	
	private double kucultmeKatsayisi;

	// GETTERS AND SETTERS:
	public double getKucultmeKatsayisi() {
		return kucultmeKatsayisi;
	}

	public void setKucultmeKatsayisi(double kucultmeKatsayisi) {
		this.kucultmeKatsayisi = kucultmeKatsayisi;
	}
	
	//-----------------
	public abstract void boyutlandirma(String fileType);
	
	// Aşağıdaki metotları Interface'lerle sağlayacağız: ISocialMedya, IPostabla, IVideoCallable.
//	public abstract void postGonder();
//	public abstract void sohbetEt(); 
//	public abstract void resimPaylas();
//	public abstract void videoKonferansYap();
}
