package pckg_lesson031_etut;

import java.util.UUID;

public class Kitap {
	private int id;
	private String isim;
	private Yazar yazar;
	private int sayfaSayisi;
	private String ısbnKodu;

	public Kitap(String isim, int sayfaSayisi) {
		super();
		this.isim = isim;
		this.sayfaSayisi = sayfaSayisi;
		this.ısbnKodu = UUID.randomUUID().toString();
		this.id = ++Utility.kitapId;

	}

	public Kitap(String isim, int sayfaSayisi, Yazar yazar) {
		super();
		this.isim = isim;
		this.sayfaSayisi = sayfaSayisi;
		this.yazar = yazar;
		this.ısbnKodu = UUID.randomUUID().toString();
		this.id = ++Utility.kitapId;
	}

	public String getIsim() {
		return isim;
	}

	public Yazar getYazar() {
		return yazar;
	}

	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	public String getIsbnKodu() {
		return ısbnKodu;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}

	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	public void setIsbnKodu(String isbnKodu) {
		ısbnKodu = isbnKodu;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Kitap [id=" + id + ", isim=" + isim + ", yazar=" + yazar + ", sayfaSayisi=" + sayfaSayisi
				+ ", ısbnKodu=" + ısbnKodu + "]";
	}

}
