package liskovSubsitution;

import utility.Bildirim;
import utility.Kullanici;

public class Whatsapp extends SosyalMedya implements IEmailSendable, ISmsSendable, IVideoCallable {

	@Override
	public void boyutlandirma(String fileType) {
		if(fileType.equalsIgnoreCase("jpg")) {
			setKucultmeKatsayisi(88.8);
		} else if(fileType.equalsIgnoreCase("png")) {
			setKucultmeKatsayisi(99.9);
		}else {
			setKucultmeKatsayisi(77.7);
		}	
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

	@Override
	public void videoKonferans() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
