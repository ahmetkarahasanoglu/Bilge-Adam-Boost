package com.ahmet.Monolitik.repository;

import com.ahmet.Monolitik.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DOKÜMAN: (SORGULARIN NASIL YAZILACAĞI VS. [SPRING]:
 * https://docs.spring.io/spring-data/jpa/docs/2.7.7/reference/html/
 */

/**
 * Spring bir sınıfı ya da interface'i yönetmek ve ondan bir nesne
 * yaratmak için belli anotasyonlar kullanır. Repository sınıfları,
 * '@Repository' anotasyonu kullanılır.
 */
@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {

    /**
     * Burada metotların arayüzü tanımlanır (gövdesiz metot). Spring
     * Data Jpa bize bunu sunmaktadır.
     * Spring özel keyword'ler ile sorgu yazmamızı sağlar.
     * 1- find: kelimesi ile başlanır.
     * 2- By: ile işlem yapmak istediğiniz bileşeni seçersiniz.
     * 3- [entity-> değişken adı]: kullanılan repository'e atanan entity'de
     * var olan alan adını baş harfi büyük olarak yazarsınız.
     * 4- kullanılan metotta özel bir istek keyword varsa eklenir.
     * 5- geri dönüş tipini yazarsınız.
     */

    /**
     * select * from tblmusteri where ad=?
     */
    Musteri findByAd(String ad); // Burda findByAd'daki 'Ad', Musteri entity'mizdeki 'ad' alanıdır.
    Musteri findByAdres(String musterinin_adresi);
    Musteri findByAdAndAdres(String ad, String adres);
    Musteri findByAdOrTelefon(String ad, String tel); // SELECT * FROM tblmusteri WHERE ad = :ad OR telefon = :tel ||| sıralama önemli; yazdığımız parametrelerin sırası önemli; metot ismindeki sırayla aynı olmalı.
    Musteri findByTelefonAndAdAndAdres(String tel, String ad, String adres);
    List<Musteri> findAllByIl(String il); // aynı ilde birden fazla müşteri ikamet edebilir, geri dönüş tipini List yaptık.
    List<Musteri> findAllByAdStartsWith(String ad); // Adı bununla başlayan müşterileri bul.

    /**
     * DİKKAT!:
     * (???) Eğer optional kullanıyorken değer 1'den fazla döner ise hata fırlatır(???).
     */
    Optional<Musteri> findOptionalByAd(String ad);

    List<Musteri> findByOrderByAd(); // ada göre a'dan z'ye sıralar.
    List<Musteri> findByOrderByAdDesc(); // ada göre z'den a'ya sıralar.
    List<Musteri> findTop3ByOrderByAd(); // ada göre a'dan z'ye sıralanmış ilk 3 kişiyi getir.
    List<Musteri> findAllByIdIn(List<Long> ids); // ('in' means: "which equals to one of these")
    Optional<Musteri> findOptionalByUsernameAndPassword(String username, String password);
}
