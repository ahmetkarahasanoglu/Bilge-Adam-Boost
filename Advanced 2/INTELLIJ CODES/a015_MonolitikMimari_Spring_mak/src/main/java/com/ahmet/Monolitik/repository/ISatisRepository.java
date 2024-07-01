package com.ahmet.Monolitik.repository;

import com.ahmet.Monolitik.repository.entity.Satis;
import com.ahmet.Monolitik.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {

    /**
     * A kişisine neler satıldığı.
     * @param musteriId
     * @return
     */
    List<Satis> findAllByMusteriid(Long musteriId);

    /**
     * 3- En çok satış adedi olan müşteri:
     * select musteriid, sum(adet)
     * from tblsatis
     * group by musteriid
     * order by sum(adet) desc
     * limit 1
     */
    @Query(value = "select s.musteriid from Satis s group by s.musteriid order by SUM(s.adet) desc limit 1",
           nativeQuery = true)
    Long findBySumSatisAdet();

    /**
     * En çok satılan 3 ürün:
     * Select * from tblsatis group by urunid order by sum(adet) desc limit 3
     */
    @Query(value = "select s.urunid from Satis s group by s.urunid order by sum(s.adet) desc limit 3",
           nativeQuery = true)
    List<Long> findAllBySatisAdet();
}
