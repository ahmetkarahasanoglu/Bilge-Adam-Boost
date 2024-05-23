package com.ahmet.repository;

import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kisi;
import com.ahmet.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AracRepository extends MyFactoryRepository<Arac, Long> {

    public AracRepository() {
        super(new Arac());
    }

    public Arac findByMarkaAndModel(String marka, String model) {
        String hql = "select a from Arac a where a.marka = :x and a.model = :y";
        openSession();
        TypedQuery<Arac> typedQuery = getSs().createQuery(hql);
        typedQuery.setParameter("x", marka);
        typedQuery.setParameter("y", model);
        Arac arac;
        try {
            arac = typedQuery.getSingleResult();
            closeSession();
            return arac;
        }catch(Exception e) {
            throw new RuntimeException("Araç bulunamadı.");
        }
        // With CriteriaQuery:
//        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
//        Root<Arac> root = criteria.from(Arac.class);
//        Predicate markaPredicate = getCriteriaBuilder().equal(root.get("marka"), marka);
//        Predicate modelPredicate = getCriteriaBuilder().equal(root.get("model"), model);
//        criteria.select(root).where(getCriteriaBuilder().and(markaPredicate, modelPredicate));
//        List<Arac> resultList = getEntityManager().createQuery(criteria).getResultList();
//        if(resultList.isEmpty()) {
//            return null;
//        }else {
//            return resultList.get(0);
//        }
    }

    public List<Arac> findAllByDurum(boolean durum) {
        TypedQuery<Arac> typedQuery = getEntityManager().createNamedQuery("findAllByDurum", Arac.class);
        typedQuery.setParameter("durum", durum);
        return typedQuery.getResultList();
    }



}
