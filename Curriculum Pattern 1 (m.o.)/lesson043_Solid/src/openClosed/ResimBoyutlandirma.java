package openClosed;

import singleRespnsibility.Instagram;

public class ResimBoyutlandirma {

	// 1. adımda sadece instagram var, onun küçültme katsayısını belirliyoruz:
//	public void boyutlandirma(Instagram instagram, String fileType) {
//		if(fileType.equalsIgnoreCase("jpg")) {
//			instagram.setKucultmeKatsayisi(38.0);
//		} else if(fileType.equalsIgnoreCase("png")) {
//			instagram.setKucultmeKatsayisi(30.0);
//		}else {
//			instagram.setKucultmeKatsayisi(40);
//		}
//	}
	
	// 2. adımda facebook da eklendi onun da küçültme katsayısı belirlenecek:
//	public void boyutlandirma2(SosyalMedya sosyalMedya, String fileType) {
//		if(sosyalMedya instanceof Instagram) {
//			if(fileType.equalsIgnoreCase("jpg")) {
//				sosyalMedya.setKucultmeKatsayisi(38.0);
//			} else if(fileType.equalsIgnoreCase("png")) {
//				sosyalMedya.setKucultmeKatsayisi(30.0);
//			}else {
//				sosyalMedya.setKucultmeKatsayisi(40);
//			}
//		}else if(sosyalMedya instanceof Facebook) {
//			if(fileType.equalsIgnoreCase("jpg")) {
//				sosyalMedya.setKucultmeKatsayisi(34.0);
//			} else if(fileType.equalsIgnoreCase("png")) {
//				sosyalMedya.setKucultmeKatsayisi(37.0);
//			}else {
//				sosyalMedya.setKucultmeKatsayisi(45);
//			}
//		}else {
//			if(fileType.equalsIgnoreCase("jpg")) {
//				sosyalMedya.setKucultmeKatsayisi(40.0);
//			} else if(fileType.equalsIgnoreCase("png")) {
//				sosyalMedya.setKucultmeKatsayisi(42.0);
//			}else {
//				sosyalMedya.setKucultmeKatsayisi(48);
//			}
//		}
//	}
	
	public void boyutlandirma3(SosyalMedya sosyalMedya, String type) {
		sosyalMedya.boyutlandirma(type); // Burda, sosyalMedya abstract class'ının abstract metodunu çağırıyoruz. Bu metot da; facebook, instagram ve whatsapp'ta implement edilmiş bir metot ('boyutlandırma' metodu)
	}
}
