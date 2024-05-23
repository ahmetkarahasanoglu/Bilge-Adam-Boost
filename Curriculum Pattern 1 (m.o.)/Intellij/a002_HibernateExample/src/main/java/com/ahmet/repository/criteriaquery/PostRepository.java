package com.ahmet.repository.criteriaquery;

import com.ahmet.repository.entity.Post;
import com.ahmet.repository.entity.User;
import com.ahmet.repository.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * 12- Her bir kullanıcı kaç post atmış bulalım.
 * 13- 3'ten fazla post atmış kullanıcı id'lerini dönelim
 */
public class PostRepository {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    // CONSTRUCTOR:
    public PostRepository() {
        entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    // METHODS: -----
    public void postCountOfEachUser(){
        CriteriaQuery<Tuple> criteria = criteriaBuilder.createQuery(Tuple.class);
        Root<Post> root = criteria.from(Post.class);
        criteria.multiselect(root.get("userid"), criteriaBuilder.count(root)).groupBy(root.get("userid"));
        List<Tuple> tuples = entityManager.createQuery(criteria).getResultList();
        tuples.forEach(x -> {
            System.out.println("User Id: " + x.get(0) + " - Post Count: " + x.get(1));
        });
    }

    public void postCountOfEachUserGreaterThan3() {
        CriteriaQuery<Tuple> criteria = criteriaBuilder.createQuery(Tuple.class);
        Root<Post> root = criteria.from(Post.class);
        // Amacımız (~sql): select userId, count(userid) from tbl_post group by userid having count(userid)>3
        Path<Long> userId = root.get("userid");
        Expression<Long> count = criteriaBuilder.count(root.get("userid"));
        criteria.multiselect(userId, count).groupBy(userId).having(criteriaBuilder.greaterThan(count, 3L));

        List<Tuple> tuples = entityManager.createQuery(criteria).getResultList();
        System.out.println("--- Users of which post count is greater than 3: ---");
        tuples.forEach(x -> {
            System.out.println("User Id: " + x.get(0) + " - Post Count: " + x.get(1));
        });
    }

}
