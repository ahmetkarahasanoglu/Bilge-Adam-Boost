package com.ahmet.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory(); // 'configure()'e parametre olarak configuration dosyamızın ismini yazmadık ama, 'resources' klasörünün altında arayıp bulur. Parantezin içine xml dosyamızı yazmasak da yine buluyo (default dosya ismini bilir).
        }catch(Exception e) {
            System.out.println("Hibernate işlem hatası....: " + e.toString());
            throw new ExceptionInInitializerError();
        }
    }

    // getter:
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
