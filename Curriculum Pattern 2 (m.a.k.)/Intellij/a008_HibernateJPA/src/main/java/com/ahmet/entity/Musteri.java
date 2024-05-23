package com.ahmet.entity;

import javax.persistence.*;

/**
 *   HIBERNATE kullanımı:
 * - Anotasyonlar oluşturacağız: Bir sınıfın Hibernate ya da diğer ORM
 * araçlarının kullanabileceği bir sınıf olduğunu belirtmek için.
 * @Entity -> "bu bir varlık sınıfıdır" demektir.
 * @Table -> oluşturulacak tablonun özelliklerini girdiğimiz kısım.
 * name -> Veritabanında aranılacak olan, ya da yok ise yaratılacak olan tablo adıdır.
 *
 */

@Entity() // ('Javax.persistence'dan import ettik)
@Table(name = "tblmusteri") // veritabanındaki hangi tabloya karşılık geldiğini yazıyoruz.
public class Musteri {

    @Id // aşağıdakinin bir id olduğunu (primary key) belirtiyoruz. - Her ORM aracı 'primary key' ile işlem yapabilir; bu nedenler primary key olmadan entity yaratamazsınız. Bir alanın (değişkenin) primary key olarak işaretlenmesi için @Id anotasyonu eklenmelidir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'ye sequence eklemek için @GeneratedValue anotasyonu kullanmalıyız [4 strateji var, IDENTITY'yi seçtik] (veri eklendikçe kendisi otomatik artacak). (veritabanında bunu sağlamak için 'serial' ya da 'bigserial' değişken tipi seçiyorduk ID'yi, kendisi otomatik arttırıyorudu ID'yi. - Burda ise sequence kullanmamız gerekiyor otomatik artması için)
    Long id;
    String ad;
    String adres;
    String telefon;

    // CONSTRUCTOR 1:
    public Musteri() {
    }

    // CONSTRUCTOR 2: (sadece id alanı var)
    public Musteri(Long id) {
        this.id = id;
    }

    // CONSTRUCTOR 3: (id'siz)
    public Musteri(String ad, String adres, String telefon) {
        this.ad = ad;
        this.adres = adres;
        this.telefon = telefon;
    }

    // CONSTRUCTOR 4:
    public Musteri(Long id, String ad, String adres, String telefon) {
        this.id = id;
        this.ad = ad;
        this.adres = adres;
        this.telefon = telefon;
    }

    // GETTERS AND SETTERS:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

}
