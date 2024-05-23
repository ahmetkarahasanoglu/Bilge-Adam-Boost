package pckg_lesson031_etut;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Uygulama implements ICrud {

	Kitaplik kitaplik;

	public Uygulama(Kitaplik kitaplik) {
		super();
		this.kitaplik = kitaplik;
	}

	public Uygulama() {
		super();
		this.kitaplik = new Kitaplik();
	}

	@Override
	public void kitapEkle() {
		String ad = Utility.stringDegerAlma("Lütfen kitap ismini giriniz");
		int sayfaSayisi = Utility.intDegerAlma("Lütfen kitabın sayfa sayısını giriniz");
		String yazarIsımSoyIsım = Utility.stringDegerAlma("Lütfen Yazar ismini giriniz");
		Yazar yazar = yazarKontrol(yazarIsımSoyIsım);
		Kitap kitap = new Kitap(ad, sayfaSayisi, yazar);

		kitaplik.getKitaplar().add(kitap);
		yazar.getKitaplar().add(kitap);
		kitaplik.getYazaraGoreKitaplar().put(yazarIsımSoyIsım, yazar.getKitaplar());
		ismeGorekitapEkle(kitap, ad, kitaplik.getIsmeGoreKitaplar());

	}

	private void ismeGorekitapEkle(Kitap kitap, String ad, Map<String, List<Kitap>> map) {
		List<Kitap> kitaplar = new ArrayList<>();

		if (map.containsKey(ad)) {
			kitaplar = map.get(ad);
			kitaplar.add(kitap);
		} else {
			kitaplar.add(kitap);
		}

		map.put(ad, kitaplar);

//		List<Kitap> kitaplar = new ArrayList<>();
//		for (int i = 0; i < kitaplik.getKitaplar().size(); i++) {
//
//			if (kitaplik.getKitaplar().get(i).getIsim().equalsIgnoreCase(ad)) {
//				kitaplar.add(kitaplik.getKitaplar().get(i));
//			} else {
//				kitaplar.add(kitaplik.getKitaplar().get(i));
//			}
//		}

	}

	public Yazar yazarKontrol(String yazarIsmi) {

		if (kitaplik.getIsmeGoreYazarlar().containsKey(yazarIsmi)) {
			System.out.println("Daha once Eklenmiş Yazar");
			return kitaplik.getIsmeGoreYazarlar().get(yazarIsmi);
		} else {
			int yas = Utility.intDegerAlma("Yazarın yasını giriniz");
			Yazar yazar = new Yazar(yazarIsmi, yas);
			kitaplik.getIsmeGoreYazarlar().put(yazarIsmi, yazar);
			return yazar; 
		}

	}

	@Override
	public void kitapSil() {
		// TODO Auto-generated method stub

	}

	@Override
	public Kitap ismeGoreKitapBul() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kitap> yazarinKitaplariniBul() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kitap> kitaplariListele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yazar> yazarlariListele() {
		// TODO Auto-generated method stub
		return null;
	}

}
