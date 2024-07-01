package com.ahmet;

import com.ahmet.ornekcriteriakullanimi.CriteriaUsing;
import com.ahmet.repository.MusteriRepository;
import com.ahmet.repository.entity.ECinsiyet;
import com.ahmet.repository.entity.Musteri;
import com.ahmet.repository.entity.Urun;
import com.ahmet.service.MusteriService;
import com.ahmet.utility.HibernateUtility;
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        // *** Yeni yazdığımız MyFactoryRepository'yi kullandığımız kısım aşağıda main metodu içerisinde yıldızlı satırların altında.

//    saveMusteri();
//    saveUrun();
//    list(); -> deprecated (tanımladığımız metodun içeriği -> deprecated)

        CriteriaUsing cr = new CriteriaUsing();
//        cr.findAll();
//        cr.selectOneColumn();
//        cr.selectManyColumn();
//        cr.usingTuple();


//        cr.multipleRoot().forEach(x -> {
//            System.out.println(((Musteri)x.get(0)).toString());
//            System.out.println(((Urun)x.get(1)).toString());
//            System.out.println("*****************************");
//        });

//        cr.usingParameter("Deniz"); // adı 'Deniz' olan kayıtları(satırları) getir.

//        cr.usingPredicate();

//        cr.groupBy();

//        cr.nativeQuery_findAll();

//        cr.namedQuery_findAll();

//        cr.namedQuery_findByAd("Deniz");
//        cr.namedQuery_findByAd("mahmut");

//        cr.namedQuery_findById(5L);

//        cr.namedQuery_getCountAll();

//        cr.typedQuery_setProperties(1, 3);

//        Musteri musteri = Musteri.builder()
//                .ad("Muhammet")
//                .soyad("HOCA")
//                .adres("Ankara")
//                .cinsiyet(ECinsiyet.ERKEK)
//                .build();
//        MusteriRepository musteriRepository = new MusteriRepository();
//        musteriRepository.save(musteri);

        // *******************************************************
        // *******************************************************
        // *******************************************************
        // *******************************************************

        MusteriRepository musteriRepository = new MusteriRepository();
        musteriRepository.findByEntity(Musteri.builder().ad("a").soyad("A").build()).forEach(x -> { // adında 'a' geçen ve soyadında 'A' geçenleri bul. || burda 'findByEntity()' metodu MyFactoryRepository sınıfından geliyo.
            System.out.println("Müşteri...: " + x.getAd() + " " + x.getSoyad());
        });

//        musteriRepository.findAllByColumnNameAndValue("soyad", "TEKİR").forEach(x -> { // soyadı 'TEKİR' olanları getir.
//            System.out.println("Müşteri...: " + x.getAd() + " " + x.getSoyad());
//        });

//        musteriRepository.save(Musteri.builder()
//                        .ad("Kenan")
//                        .soyad("TEKİR")
//                        .cinsiyet(ECinsiyet.ERKEK)
//                .build());
//        System.out.println("-----");
//        musteriRepository.findAll().forEach(x -> {
//            System.out.println("Müşteri...: " + x.getAd() + " " + x.getSoyad());
//        });
        //------------------

        MusteriService musteriService = new MusteriService();
        musteriService.findByEntity(Musteri.builder().ad("a").soyad("A").build()).forEach(x -> {
            System.out.println("Müşteri...: " + x.getAd() + " " + x.getSoyad());
        });

    }//MAIN ENDS HERE ----

    private static void criteriaList() {
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Session session = HibernateUtility.getSessionFactory().openSession();
        /**
         * Tüm datayı çekmek
         * criteriaQuery aslında bizim, Select * from tblmusteri sorgusunu
         * ve bu sorgu neticesinde dönecek alanların neler olduğunu
         * çözebilmesi için hazırlanıyor.
         * select id, ad, soyad, cinsiyet, .... from tblmusteri
         */
        CriteriaQuery<Musteri> criteria = builder.createQuery(Musteri.class);
        Root<Musteri> root = criteria.from(Musteri.class);
        criteria.select(root);
        List<Musteri> listem = entityManager.createQuery(criteria).getResultList();
        listem.forEach(x -> {
            System.out.println("Ad.....: " + x.getAd());
        });
    }

    private static void list() { // deprecated -> session.createCriteria is deprecated (Artık kullanılmıyor). || ~ bir tablodaki değerleri listeleme (veritabanındaki)
        Session session = HibernateUtility.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Musteri.class);
        List<Musteri> musteriList = cr.list();
        session.close();
//        musteriList.forEach(System.out::println); // bi hata verdi toString() metoduyla ilgili, o yüzden kullanmadık bunu.
        musteriList.forEach(x -> {
            System.out.println("Müşteri Ad Soyad: " + x.getAd() + " " + x.getSoyad());
        });
    }

    private static void saveMusteri() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> telList = Arrays.asList("0 555 888 9977", "0 999 777 4433");
        Musteri musteri = Musteri.builder()
                .ad("Selami")
                .soyad("HOCA")
                .cinsiyet(ECinsiyet.ERKEK)
                .adres("Konya")
                .telefonlistesi(telList)
                .build();
        session.save(musteri);
        transaction.commit();
        session.close();
    }

    private static void saveUrun() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> telList = Arrays.asList("0 555 888 9977", "0 999 777 4433");
        Urun urun = Urun.builder()
                .kdv(18)
                .model("B Model")
                .marka("A Marka")
                .fiyat(544d)
                .ad("Seker")
                .build();
        session.save(urun);
        transaction.commit();
        session.close();
    }

}//CLASS ENDS HERE ----