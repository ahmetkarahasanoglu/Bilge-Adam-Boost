package com.ahmet.ornekcriteriakullanimi;

import com.ahmet.repository.entity.Musteri;
import com.ahmet.repository.entity.Urun;
import com.ahmet.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CriteriaUsing {

    private EntityManager entityManager;
    private CriteriaBuilder builder;

    // CONSTRUCTOR:
    public CriteriaUsing() {
        entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        builder = entityManager.getCriteriaBuilder();
    }

    public List<Musteri> findAll() {
        CriteriaQuery<Musteri> criteria = builder.createQuery(Musteri.class); // 'Musteri.class' refers to the result class. / Öncelikle, kullanılacak sınıf, criteria'ya işlenir. [Sorgumuz bize 'Musteri' sınıfından bir şeyler getirecek diye belirttik (aşağıda 'getResultList()' getirecek)
        Root<Musteri> root = criteria.from(Musteri.class); // Hangi entity (tablo) varlığına select atılacağı belirlenir. (Musteri tablosu)
        criteria.select(root); // It specifies that all columns of the Musteri entity will be selected. || root: tablonun hepsini seç demektir.
        List<Musteri> musteriList = entityManager.createQuery(criteria).getResultList(); // executing selection and assigning to musteriList
        musteriList.forEach(x -> {
            System.out.println(x.getId() + " - " + x.getAd());
        });
        return musteriList;
    }

    public void selectOneColumn() {
        /**
         * select ad from tblmusteri where soyad = 'HOCA' -> sorgusunun kodunu yazalım:
         */
        CriteriaQuery<String> criteria = builder.createQuery(String.class); // We're specifying what kind of data we want to retrieve from the database; we want to receive a list of 'Strings'. || 'String.class' -> sorgumuz bize bir string array'i getireceği için burada 'String.class' kullandık. Yani aşağıdaki 'getResultList()' bize bir string array'i getireceğinden dolayı.
        Root<Musteri> root = criteria.from(Musteri.class); // root is 'Musteri'; we will select from 'Musteri' table.
        criteria.select(root.get("ad")); // hangi kolonu istediğimizi yazıyoruz. || burda, veritabanındaki tablodaki sütun ismini değil de, Java'da 'Musteri' sınıfında tanımladığımız alanın ismini yazmalıyız (o da 'ad').
        criteria.where(builder.equal(root.get("soyad"), "HOCA")); // soyad'ı "HOCA" olanları. Yani diyoruz ki, soyadı "HOCA" olanların, 'musteri_ad' kolonunu getir.
        List<String> adListesi = entityManager.createQuery(criteria).getResultList(); // executing query, and assigning to List<String> adListesi
        adListesi.forEach(System.out::println);
    }

    public void selectManyColumn() {
        /**
         * select id, ad, soyad from tblmusteri -> çoklu sütun getirmek (farklı tiplerde: Long, String vs.). Object array'i kullanacağız. - [ama sadece String değişkenler getirilecekse String array'i kullanabiliriz].
         */
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class); // we specify that result will be an array of objects.
        Root<Musteri> root = criteria.from(Musteri.class); // root will be 'Musteri'. Data will be fetched from 'Musteri' entity.
        Path<Long> idPath = root.get("id"); // Musteri sınıfımdaki id'nin tipi 'Long' idi.
        Path<String> adPath = root.get("ad");
        Path<String> soyadPath = root.get("soyad");
        criteria.select(builder.array(idPath, adPath, soyadPath)); // forming the selection part.
        List<Object[]> mlist = entityManager.createQuery(criteria).getResultList(); // executing query and assigning to the object list (mlist).
        mlist.forEach(x -> {
//            System.out.println("data.....:" + x); // bu, objenin RAM'deki adresini getiriyor.
            for(Object o : x) { // 'x' bir satırı simgeliyor(mlist'in), 'o' ise satırın her bir alanı.
                System.out.print(o + " ");
            }
            System.out.println();
        });
    }

    public void usingTuple() { // selecting many columns by using 'Tuple'
        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class); // gelen tablo verisini burda Object array'i yerine 'Tuple' ile işliyoruz.
        Root<Musteri> root = criteria.from(Musteri.class); // root will be 'Musteri'. Data will be fetched from 'Musteri' entity.
        Path<Long> idPath = root.get("id");
        Path<String> adPath = root.get("ad");
        Path<String> soyadPath = root.get("soyad");
        criteria.multiselect(idPath, adPath, soyadPath); // böyle bir kullanım da var; şunun yerine kullandık:  criteria.select(builder.array(idPath, adPath, soyadPath));
        List<Tuple> tupleList = entityManager.createQuery(criteria).getResultList(); // executing query and assigning to tupleList.
        tupleList.forEach(x -> {
            System.out.println("id.....: " + x.get(idPath)); // alan ismi belirterek aldık burda.
            System.out.println("ad.....: " + x.get(1)); // index belirterek aldık burda.
            System.out.println("soyad..: " + x.get(2));
        });
    }

    public List<Tuple> multipleRoot() {  // *** 1'den fazla tablodan veri getirmek. Full-cross join yapıp sonucu getirir (iki tabloyu kartezyen çarpım gibi yapar)
        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class); // gelen tablo verisini 'Tuple' ile işliyoruz; sorgumuz bize bir 'Tuple' getirecek. / specifying that result will be a list of tuples.
        Root<Musteri> rootMusteri = criteria.from(Musteri.class); // root will be 'Musteri'. Data will be fetched from 'Musteri' entity.
        Root<Urun> rootUrun = criteria.from(Urun.class); // creating another root for urun table.
        criteria.multiselect(rootMusteri, rootUrun); // selecting both 'Musteri' and 'Urun' roots; all columns from both tables.
        List<Tuple> tupleList = entityManager.createQuery(criteria).getResultList(); // executing query and assigning to tupleList.
        return tupleList;
    }

    public void usingParameter(String musteriAdi) {
        CriteriaQuery<Musteri> criteria = builder.createQuery(Musteri.class); // setting up a criteria query. This is a way to build a structured query to find objects of type Musteri.
        Root<Musteri> root = criteria.from(Musteri.class); // we specify the root as Musteri object. It tells the query to start looking for Musteri objects from the Musteri class.

        ParameterExpression<String> nickName = builder.parameter(String.class); // our parameter 'nickName' is like a placeholder for a value that we will provide later. We specified that its type is 'String'.
        criteria.where(builder.equal(root.get("ad"), nickName)); // 'ad' is the field in 'Musteri' class. || We specified that 'query' should return records where 'ad' is equal to 'nickName'.

        TypedQuery<Musteri> query = entityManager.createQuery(criteria); // Type of the query is 'Musteri', which says that it will return instances of 'Musteri' entity.
        query.setParameter(nickName, musteriAdi); // nickName'e değer ataması yaptık(dışardan aldığımız musteriAdi'ni atadık)
        List<Musteri> musteriList = query.getResultList(); // query is executed and obtained as a List of 'Musteri' objects.
        musteriList.forEach(x -> {
            System.out.println(x.getId() + " -> " + x.getAd() + " " + x.getSoyad());
        });
    }

    public void usingPredicate() {
        /**
         * select * from tblmusteri where ad like 'm%' and soyad is not null and id>2
         */
        CriteriaQuery<Musteri> criteria = builder.createQuery(Musteri.class); // specifying that the result will be a list of Musteri objects.
        Root<Musteri> root = criteria.from(Musteri.class); // specifying root as 'Musteri'. Data will be fetched from 'Musteri' table.

        Predicate predicateMusteri_1 = builder.and( // combining conditions with 'and'.
                builder.like(root.get("ad"), "M%"), // where 'ad' starts with 'M%' and
                builder.isNotNull(root.get("soyad")) // and soyad is not null.
        );
        Predicate predicateMusteri_2 = builder.and(
                builder.greaterThan(root.get("id"), 3) // where 'id' is greater than 3.
        );

        criteria.where(builder.or(predicateMusteri_1, predicateMusteri_2)); // using 'or' for the conditions set above.
        List<Musteri> musteriList = entityManager.createQuery(criteria).getResultList(); // executing query, assigning to musteriList.
        musteriList.forEach((x -> {
            System.out.println(x.getId() + "--> " + x.getAd());
        }));
    }

    public void groupBy() {
        /**
         * Adı aynı olan müşterilerin sayıları nedir?
         * select ad, count(*), sum(?mesela) frum tblmusteri group by ad
         */
        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
        Root<Musteri> root = criteria.from(Musteri.class);

        criteria.groupBy(root.get("ad"));
        criteria.multiselect(root.get("ad"), builder.count(root));

        List<Tuple> list = entityManager.createQuery(criteria).getResultList();

        list.forEach(x -> {
            System.out.println("ad....: " + x.get(0) + " -> " + x.get(1));
        });
    }

    public void nativeQuery_findAll() {
        /**
         * 'Java Persistence Api' üzerinden hibernate ile SQL
         * sorgularını hazırlayıp çalıştırdık. Simdi ise:
         * Tüm ORM araçlarında kullanılan yapıların yetersiz
         * kalabileceği durumlar olabilir, ya da yazılan kodların
         * karmaşıklaşarak odaktan uzaklaşılmaya sebep olabilir.
         * Bütün bu sebeplerden dolayı belli sorgularda ham SQL
         * komutlarını çalıştırmak isteyebiliriz.
         */
        // --Teacher's Code:
        List<Object[]> mlist = entityManager.createNativeQuery("select id,musteri_ad,soyad,email,cinsiyet from tblmusteri").getResultList(); // Burda tabloya veritabanındaki ismiyle hitap ediyoruz(tblmusteri) || burda alanlara 'uuid'yi ekleyince hata veriyor, bi problem var uuid'yle ilgili.
        mlist.forEach(x -> {
            System.out.println(Arrays.asList(x).get(0) + " - " + Arrays.asList(x).get(1));
        });
        // --ChatGpt's Code:
//        List<Musteri> mlist = entityManager.createNativeQuery("select * from tblmusteri", Musteri.class).getResultList();
//        mlist.forEach(x -> {
//            System.out.println(x.getId() + " " + x.getAd() + " " + x.getSoyad());
//        });
    }

    /**
     * NamedQuery'leri, class'ı tanımladığımız yerde(Musteri class'ında)
     * anotasyon(@) ile tanımlıyoruz.
     */
    public void namedQuery_findAll() {
        TypedQuery<Musteri> namedQuery = entityManager.createNamedQuery("Musteri.findAll", Musteri.class); // 'Musteri.class': bu sorgu sonucunda dönen şeyin 'Musteri.class' sınıfından olmasını belirtiyoruz.
        List<Musteri> mlist = namedQuery.getResultList();
        mlist.forEach(x -> {
            System.out.println(x.getId() + " " + x.getAd());
        });
    }

    /**
     * Müşteri adına göre arama yapan metot'dur.
     * @param ad musteri adını verirken, filtrelemek için '%'
     *           karakteri kullanınız. Örneğin: %can%
     */
    public void namedQuery_findByAd(String ad) {
        TypedQuery<Musteri> typedQuery = entityManager.createNamedQuery("Musteri.findByAd", Musteri.class);
        typedQuery.setParameter("musterinin_adi", ad);
        List<Musteri> musteriList = typedQuery.getResultList();
        musteriList.forEach(x -> {
            System.out.println(x.getId() + " --> " + x.getAd() + " " + x.getSoyad());
        });
    }

    public void namedQuery_findById(Long id) {
        TypedQuery<Musteri> typedQuery = entityManager.createNamedQuery("Musteri.findById", Musteri.class);
        typedQuery.setParameter("musterinin_id", id);
//        Musteri musteri = typedQuery.getSingleResult();
//        System.out.println(musteri.getId() + " --> " + musteri.getAd() + " " + musteri.getSoyad());
        // '--> Yukarıdaki, belirtilen id'li bir müşteri bulunamadığında hata verir. Onun yerine şu yapıyı kullanırız:
        Optional<Musteri> result;
        try{
            Musteri musteri = typedQuery.getSingleResult();
            result = Optional.of(musteri);
        }catch(Exception e) {
            System.out.println("Hata oldu...: " + e.toString());
            result = Optional.empty();
        }
        if(result.isPresent()) {
            System.out.println(result.get().getId() + " --> " + result.get().getAd() + " " + result.get().getSoyad());
        }
    }

    public void namedQuery_getCountAll() {
        TypedQuery<Long> typedQuery = entityManager.createNamedQuery("Musteri.getCountAll", Long.class); // --> buraya 'Long' yerine 'Integer' da yazılabilir; kayıt(satır) sayısını yazdıracağız sonuçta.
        Long count = typedQuery.getSingleResult();
        System.out.println("Musteri sayısı.....: " + count);
    }

    public void typedQuery_setProperties(int page, int count) {
        /**
         * Pagination -> sayfalama demektir.
         */
        TypedQuery typedQuery = entityManager.createNamedQuery("Musteri.findAll", Musteri.class);
        typedQuery.setMaxResults(count); // 'count' adet kayıt gösterecek.
        typedQuery.setFirstResult(page*count); // sayfa??
        List<Musteri> musteriList = typedQuery.getResultList();
        musteriList.forEach(x -> {
            System.out.println(x.getId() + " " + x.getAd());
        });
    }

}
