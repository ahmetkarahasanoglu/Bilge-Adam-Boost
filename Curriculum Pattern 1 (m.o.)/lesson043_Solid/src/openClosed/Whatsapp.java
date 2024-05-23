package openClosed;

public class Whatsapp extends SosyalMedya {

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
	
	
	
}
