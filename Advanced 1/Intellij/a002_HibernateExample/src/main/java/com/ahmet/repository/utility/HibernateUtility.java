package com.ahmet.repository.utility;

import com.ahmet.repository.entity.Post;
import com.ahmet.repository.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

    private static SessionFactory sessionFactoryHibernate() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class); // normalde class mapping'i biz hibernate.cfg.xml'de yazıyorduk. Onun yerine burda da bu şekilde yazabiliyoruz, bu da bir yöntem.
            configuration.addAnnotatedClass(Post.class); // '--> same concept
            SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return factory;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // getter:
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
