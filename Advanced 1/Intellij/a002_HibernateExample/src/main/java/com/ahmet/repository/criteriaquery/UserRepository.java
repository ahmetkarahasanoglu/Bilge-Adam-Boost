package com.ahmet.repository.criteriaquery;

import com.ahmet.repository.entity.ICrud;
import com.ahmet.repository.entity.Name;
import com.ahmet.repository.utility.HibernateUtility;
import com.ahmet.repository.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * 1- findAll fonksiyonu yazalım (CriteriaQuery ile)
 * 2- findAllUsername
 * 3- findById --> dışarıdan bir id alacağız, bu id'ye ait user'ı döneceğiz.
 * 4- findByUsername --> dışarıdan bir username alacağız...
 * 5- ismi 'dışardan alınan bir string ifade' ile başlayanları getiren sorgu.
 * 6- ismi 'dışardan alınan bir string ifade' ile başlayıp ve postcount'u 6'nın üzerinde olanları getiren metot.
 * 7- Tüm kullanıcıların post sayısı toplamını getiren metot.
 * 8- En az post atan kullanıcı.
 * 9- En çok post atan kullanıcı.
 * 10- Kullanıcıların username, gender ve postcount'unu dönen metot.
 * 11- Erkek kullanıcı sayısı ve kadın kullanıcı sayısını bulan metot
 * 12- postcount'u 7'nin üzerinde olan kullanıcı sayısı
 */
public class UserRepository implements ICrud<User> {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    // CONSTRUCTOR:
    public UserRepository() {
        entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    // METHODS: ----
    public List<User> findAll() {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        List<User> userList = entityManager.createQuery(criteria).getResultList();
        return userList;
    }

    public Optional<User> findById(Long id) {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(criteriaBuilder.equal(root.get("id"), id));
//        criteria.where(criteriaBuilder.equal(root.get("id"), id)); // bu satırı üst satırda select sorgusuyla birleştirerek yazdık.
        User user = null;
        try {
            user = entityManager.createQuery(criteria).getSingleResult();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUsername(String username) {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(criteriaBuilder.equal(root.get("username"), username));
        User user = null;
        try {
            user = entityManager.createQuery(criteria).getSingleResult();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(user);
    }

    public List<String> selectOneColumn_findAllFirstName() { // 'Name' is a class, it has fields.
        CriteriaQuery<String> criteria = criteriaBuilder.createQuery(String.class); // We're specifying what kind of data we want to retrieve from the database; we want to receive a list of 'Strings'. || 'String.class' -> sorgumuz bize bir string array'i getireceği için burada 'String.class' kullandık. Yani aşağıdaki 'getResultList()' bize bir string array'i getireceğinden dolayı.
        Root<User> root = criteria.from(User.class);
        criteria.select(root.get("name").get("firstname")); // 'name' objesinin içindeki 'firstname' alanlarını getir diyoruz.
        List<String> firstNameList = entityManager.createQuery(criteria).getResultList();
        return firstNameList;
    }

    public List <User> findByUsernameStartsWithTheValue(String value) {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(criteriaBuilder.like(root.get("name").get("firstname"), value+"%"));
        // Yukardaki sorgu satırını yazmanın 2'nci yöntemi aşağdaki 2 satırda:
//        Predicate predicate = criteriaBuilder.like(root.get("name").get("firstname"), "M%");
//        criteria.where(predicate);
        List<User> ismi_M_ileBaslayanUserlar = entityManager.createQuery(criteria).getResultList();
        return ismi_M_ileBaslayanUserlar;
    }

    public List <User> findByUsernameStartsWithTheValueAndPostCountAbove6(String value) {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
//        criteria.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("name").get("firstname"), value+"%"),
//                criteriaBuilder.greaterThan(root.get("postcount"), 6)
//                ));
        // Üstteki criteria koşul zincirlemesini şu şekilde de yazabiliriz:
        Predicate predicLike = criteriaBuilder.like(root.get("name").get("firstname"), "M%");
        Predicate predicGreaterThan = criteriaBuilder.greaterThan(root.get("postcount"), 6);
        criteria.select(root).where(criteriaBuilder.and(predicLike, predicGreaterThan));

        List<User> users = entityManager.createQuery(criteria).getResultList();
        return users;
    }

    public int totalPostCountOfAllUsers() {
        CriteriaQuery<Integer> criteria = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(criteriaBuilder.sum(root.get("postcount")));
        Integer totalPostCount = entityManager.createQuery(criteria).getSingleResult();
        return totalPostCount;
    }

    public User userWithLowestPostCount() {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).orderBy(criteriaBuilder.asc(root.get("postcount")));
        User user = entityManager.createQuery(criteria).getResultList().get(0);
        return user;
    }

    public User userWithHighestPostCount() {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).orderBy(criteriaBuilder.desc(root.get("postcount")));
        User user = entityManager.createQuery(criteria).getResultList().get(0);
        return user;
    }

    public List<Object[]> get_username_gender_postcount_ofAllUsers() {
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteria.from(User.class);
        criteria.multiselect(root.get("username"), root.get("gender"), root.get("postcount"));
        List<Object[]> userListWithSomeFields = entityManager.createQuery(criteria).getResultList();
        return userListWithSomeFields;
    }

    public List<Tuple> get_username_gender_postcount_ofAllUsers2() {
        CriteriaQuery<Tuple> criteria = criteriaBuilder.createQuery(Tuple.class);
        Root<User> root = criteria.from(User.class);
        criteria.multiselect(root.get("username"), root.get("gender"), root.get("postcount"));
        List<Tuple> userListWithSomeFields = entityManager.createQuery(criteria).getResultList();
        return userListWithSomeFields;
    }

    public List<Object[]> userCountByGender() {
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteria.from(User.class);
        // Amacımız (~sql): select gender, count(*) from User group by gender
        criteria.multiselect(root.get("gender"), criteriaBuilder.count(root)).groupBy(root.get("gender"));
        return entityManager.createQuery(criteria).getResultList();
    }


}
