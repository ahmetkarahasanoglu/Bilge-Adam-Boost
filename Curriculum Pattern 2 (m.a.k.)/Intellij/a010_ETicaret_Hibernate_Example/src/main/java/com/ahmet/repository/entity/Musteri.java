package com.ahmet.repository.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Project Lombok -> kolaylık sağlayan bir eklenti. Otomatik getter&setter, constructor, toString, hashCode oluşturuyor.
 *   - Ayarlar'da plugin kısmından ekliyoruz.
 *   - Bağımlılıklarını Maven Repository sitesinden alıp
 *     build.gradle'a ekliyoruz. -> 2 satır olarak yazdık: implementation, ve annotationProcessor
 */

@NamedQueries({ // hql kullanarak 'NamedQuery' oluşturmak (Runner'da kullanacaz bu sorguları). || 'NamedQuery' ön bellekleme yapabiliyor. Bu nedenle aynı sorgu tekrar çağrılır ise bellekten sonuç döner.
        @NamedQuery(name = "Musteri.findAll", query = "SELECT m from Musteri m"), // "Musteri.findAll" ismini biz verdik, önce sınıf sonra nokta koyup 'findAll' olsun, sınıfa özel olcak bu sorgu çünkü. || sondaki 'Musteri m' 'Musteri as m' anlamında. / 'SELECT m' yazılan yerde 'SELECT m.id, m.ad' gibi şeyler de yazabiliriz.
        @NamedQuery(name = "Musteri.findByAd", query = "select m from Musteri m where lower(m.ad) like lower(:musterinin_adi)"), // 'ilike' çalışmadığı için iki tane 'lower' kullandık. || ':musterininadi' -> dışarıdan parametre alacağımız zaman iki nokta(:) ve parametrenin adini yazıyoruz.
        @NamedQuery(name = "Musteri.findById", query = "select m from Musteri m where m.id = :musterinin_id"),
        @NamedQuery(name = "Musteri.getCountAll", query = "select count(m) from Musteri m"),
        @NamedQuery(name = "Musteri.findAllNameSurname", query = "select concat(m.ad,' ',m.soyad) from Musteri m")
})
@Entity
@Table(name = "tblmusteri", schema = "public")
@Builder // lombok'tan. Builder: Bir sınıftan nesne üretmek için özel anotasyon.
@Data // lombok'tan. Data: get & set metotlarını tanımlar.
@NoArgsConstructor// lombok'tan. Parametresiz constructor tanımlar.
@AllArgsConstructor // lombok'tan. Tüm parametrelerle constructor tanımlar.
@ToString // lombok'tan. toString metodunun tanımlar class'ımız için.
public class Musteri {
    /**
     * Tablolarda ID için benzersiz alan oluşturma yöntemleri;
     * 1- Otomatik SQ ile oluşturma; (IDENTITY, TABLE, SEQUENCE, AUTO)
     * 2- Elle SQ oluşturarak atama
     * 3- UUID oluşturarak elle atama
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik SQ
    Long id;

    @SequenceGenerator(name = "sq_ozel_musteri_id", sequenceName = "sq_ozel_musteri_id", allocationSize = 5, initialValue = 1000) // elle SQ ||| name: bu sayfada bi aşağıdaki 'GeneratedValue'nun kullanacağı ad. || sequenceName: vertiabanında sequence'lerin altında görünecek isim. || allocationSize: kaçar kaçar artacağı. || initialValue: başlangıç değeri.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_ozel_id")
    Long musteri_id;

    @GenericGenerator(name = "name_uuid", strategy = "uuid2") // uuid oluşturarak elle atama.
    @GeneratedValue(generator = "name_uuid")
    UUID uuid;

    /**
     * Tablolarda alanların özelleştirilmesi (aşağıdaki 'ad' alanı için):
     * - insertable = true; insert into tblmusteri(id,ad) values(?,?)
     * - insertable = false; insert into tblmusteri(id) values(*)
     */
    @Column(name = "musteri_ad", length = 100, nullable = false, unique = false, insertable = true, updatable = false) // 'nullable' ve 'insertable'ın aynı anda 'false' olması mantık olarak aykırıdır.
    String ad;

    @Column(length = 100)
    String soyad;

    /**
     * ## Large amount of data storing -> '@Lob' . stores large object. Such as a long text.
     */
    @Lob // --> large object (stores large amount of data)
    String adres;

    /**
     * TemporalType.DATE -> tarih belirtirken
     * TemporalType.TIME -> zamanı saati belirtirken
     * TemporalType.TIMESTAMP -> zaman damgası için (System.currentTimeMillis())
     */
    @Temporal(TemporalType.DATE)
    Date dogumtarihi;

    /**
     * Kolon oluşturmasın -> '@Transient'
     * '--> DİKKAT!!! Özellikle belirtilmediği sürece tüm tanımlar HIBERNATE
     * tarafından veritabanında tabloda kolon olarak oluşturulur.
     * Eğer bir alanı veritabanında kolon olarak oluşturmak istemiyorsanız
     * '@Transient' yazarak yapabilirsiniz [yani "transit geç, bunun için kolon oluşturma" diye düşünebilirsin]
     */
    @Transient
    String adsoyad;

    /**
     * List. When using list --> '@ElementCollection'
     * Tablolar içinde eğer liste şeklinde bilgi saklamak istiyorsak
     * '@ElementCollection' yazarak bunu belirtmeliyiz.
     */
    @ElementCollection
    List<String> telefonlistesi; // -> Bu listeye veri eklediğimizde (Runner'da), veritabanında 'tblmusteri'den ayrı bir tablo oluşturur (çünkü bu liste-verileri 1'den fazla satır olarak kaydediliyor, o yüzden tblmusteri'ye kaydedilmiyor), 'musteri_telefonlistesi' diye kendisi yeni bir tablo oluşturup oraya satır satır telefon numaralarını giriyor, ve 'musteri_id' alanını kullanarak iki tabloyu birleştiriyor.

    /**
     * To use other classes in an entity --> '@Embedded'
     * 'Iletisim' sınıfını tanımladığımız class'da '@Embeddable' şeklinde etiketleriz class'ı.
     * Not: Ayrı bir tablo oluşturmaz Iletisim sınıfının verileri için (veritabanında). Mevcut tabloya yeni sütunlar ekleyerek oluşturur (tblmusteri tablosuna)
     * '--> Şu mantığa benziyo: miras alıp içine ekleme gibi.
     */
    @Embedded
    Iletisim iletisim;

    @Embedded  // denemek amaçlı yaptık; aynı miras alma gibi.
    BaseEntity baseEntity;

    /**
     *  Enum işlenme şekli -> '@Enumerated'
     *  EnumType.STRING -> Enum bilgisi DB'de String olarak tutulur.
     *  EnumType.ORDINAL -> sayısal olarak tutar.
     */
    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;

}
