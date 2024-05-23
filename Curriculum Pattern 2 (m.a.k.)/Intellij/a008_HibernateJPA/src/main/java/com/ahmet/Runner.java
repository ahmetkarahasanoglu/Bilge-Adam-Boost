package com.ahmet;

import com.ahmet.entity.Musteri;
import com.ahmet.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * 'hibernate.cfg.xml' konfigürasyon dosyası oluşturduk [main/resources] klasöründe.
 * '-->(bu dosyanın ismi birebir böyle olmalı).
 */
public class Runner {

    public static void main(String[] args) {
//        InsertUpdateDelete();
//        InsertUpdateDelete();
//        InsertUpdateDelete();
//        InsertUpdateDelete();

        Session session = HibernateUtility.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Musteri.class);
        List<Musteri> musteriList = criteria.list();
        session.close();
        musteriList.forEach(System.out::println);

    }//MAIN ENDS HERE ----

    private static void InsertUpdateDelete() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Musteri musteri =
//                new Musteri(4L);
                new Musteri("Ayhan", "Antalya", "0 555 000 8754");
//                new Musteri(2L, "Ayhan", "Antalya", "0 555 000 8754");
        session.save(musteri); // insert (kayıt eklemek) için kullanılır. ||| save() komutunda, yukarıdaki sql parametrelerimizde bir 'id' belirtsek bile veritabanında kendisi başka bir id veriyor (veritabanındaki sıradaki id'yi).
//        session.update(musteri); // belirttiğimiz id'deki kaydı günceller.
//        session.delete(musteri); // belirttiğimiz id'deki kaydı siler.
        transaction.commit();
        session.close();
    }


}