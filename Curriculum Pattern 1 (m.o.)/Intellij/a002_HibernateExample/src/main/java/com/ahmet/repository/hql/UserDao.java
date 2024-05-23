package com.ahmet.repository.hql;

import com.ahmet.repository.entity.EGender;
import com.ahmet.repository.entity.ICrud;
import com.ahmet.repository.entity.Name;
import com.ahmet.repository.entity.User;
import com.ahmet.repository.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * UserDao --> hql sorgularımız için (UserDao ya da UserDto) eski
 *    bir yazım şekli(UserRepository yerine kullanılıyo).
 *    'Data object' anlamında.
 */
public class UserDao implements ICrud {

    @Override
    public Optional findById(Long id) {
        String hql = "select u from User as u where id=" + id;
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        User user = null;
        try{
            user = typedQuery.getSingleResult();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findById2(Long id) { // Farklı bir yöntemle findById metodu (null check yapılıyor if ile)
        User user = null;
        try{
            Session session = HibernateUtility.getSessionFactory().openSession();
            user = session.find(User.class, id); // session'ın 'find' metodu parametre olarak bir entity class, ve bir primary key alır.
            if(user==null) {
                System.out.println("Kullanıcı bulunamadı.");
                return Optional.empty();
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUsername(String username) {
//        String hql = "select u from User u where username=" + "'"+username+"'";
        String hql = "select u from User as u where username = :myusername";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        typedQuery.setParameter("myusername", username);
        User user = null;
        try {
            user = typedQuery.getSingleResult();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally{
            session.close();
        }
        return Optional.ofNullable(user);
    }

    public List<User> findByUsernameStartsWithTheValue(String value) {
        String hql = "select u from User as u where u.name.firstname like :valueplace";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        typedQuery.setParameter("valueplace", value+"%");
        List<User> userList = null;
        try {
            userList = typedQuery.getResultList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public List<User> findByUsernameStartsWithTheValueAndPostCountAbove6(String value) {
        String hql = "select u from User as u where u.name.firstname like :valueplace and u.postcount > 6";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        typedQuery.setParameter("valueplace", value+"%");
        List<User> userList = null;
        try {
            userList = typedQuery.getResultList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public long totalPostCountOfAllUsers() { // Veritabanındaki sütun 'integer' olmasına rağmen burada dönüş tipini int yapınca hata veriyor. Long yapınca çalışıyor. Default bi ayar var demek ki, 'sum()' sonucunu Long olarak veriyor
        String hql = "select sum(postcount) from User";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
        return typedQuery.getSingleResult();
//        Integer totalPostCount = null;
//        try {
//            totalPostCount = typedQuery.getSingleResult();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return totalPostCount;
    }

    public User userWithLowestPostCount() {
        String hql = "select u from User u order by postcount asc";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        List<User> userList = typedQuery.getResultList();
        return userList.get(0);
//        List<User> userList = null;
//        try {
//            userList = typedQuery.getResultList();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return userList;
    }

    public User userWithHighestPostCount() {
        String hql = "select u from User u order by postcount desc";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        List<User> userList = typedQuery.getResultList();
        return userList.get(0);
//        List<User> userList = null;
//        try {
//            userList = typedQuery.getResultList();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return userList;
    }

    public List<User> get_username_gender_postcount_ofAllUsers() {
        String hql = "select u.username, u.gender, u.postcount from User u";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        List<User> userListWithSomeFields = typedQuery.getResultList();
        return userListWithSomeFields;
    }

    public List<Tuple> userCountByGender() {
        String hql = "select gender, count(u) from User as u group by gender";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Tuple> typedQuery = session.createQuery(hql, Tuple.class);
        List<Tuple> users = typedQuery.getResultList();
        return users;
    }


    @Override
    public List<User> findAll() {
        String hql = "select u from User as u"; // User: 'User' sınıfımızı(entity'mizi) belirtiyoruz.
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
        List<User> userList = typedQuery.getResultList();
        return userList;
    }

    public void findAllNameObjectOfUser() {
        String hql = "select name from User";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Name> typedQuery = session.createQuery(hql, Name.class);
        List<Name> userList = typedQuery.getResultList();
        userList.forEach(System.out::println);
    }

    public void findAllUserFirstName() {
        String hql = "select name.firstname from User";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
        List<String> firstNameList = typedQuery.getResultList();
        firstNameList.forEach(System.out::println);
    }

    public void findAllUserUsername() {
        String hql = "select username from User";
        Session session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
        List<String> usernameList = typedQuery.getResultList();
        usernameList.forEach(System.out::println);
    }
}
