package com.ahmet;

import com.ahmet.entity.Urun;
import com.ahmet.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Urun urun = new Urun("Seker", 23d);
        session.save(urun);
        transaction.commit();
        session.close();

    }//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----