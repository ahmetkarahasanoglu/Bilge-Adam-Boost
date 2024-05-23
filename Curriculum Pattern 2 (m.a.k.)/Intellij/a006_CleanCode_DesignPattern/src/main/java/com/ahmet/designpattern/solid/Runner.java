package com.ahmet.designpattern.solid;

public class Runner {

    public static void main(String[] args) {
        /**
         * SOLID - ACID - AGILE
         * Amaç:
         * 1- Yazılımın esnek olmasını ve yeniden kullanılabilir omasını
         *    sağlamak.
         * 2- Kodların daha anlaşılır olmasını sağlar ve okunabilirliği
         *    arttırır.
         * 3- Kodların modülerliğini arttırır. Sadece metot bazında değil,
         *    sınıf ve proje basında da kodların tekrar etmemesini sağlar.
         * 4- SOLID prensiplerine uygun yazarsanız zamandan tasarruf
         *    edersiniz. Sonradan kodları revize etmek zorunda kalmazsınız,
         *    geliştirmeye açık olursunuz.
         *
         *    Araştır: Singleton Design Pattern, Factory Design Pattern
         *
         *    SOLID PRENSİPLERİ:
         *    S - Single Responsibility Principle (SRP): A class should have
         *        only one reason to change.
         *    O - Open/Closed Principle (OCP): Software entities (classes,
         *        modules, functions, etc.) should be open for extension but
         *        closed for modification.
         *    L - Liskov Substitution Principle (LSP): Objects of a superclass
         *        should be replaceable with objects of a subclass without
         *        affecting the correctness of the program.
         *    I - Interface Segregation Principle (ISP): Clients should not
         *        be forced to depend on interfaces they do not use.
         *    D - Dependency Inversion Principle (DIP): High-level modules
         *        should not depend on low-level modules. Both should depend
         *        on abstractions, and abstractions should not depend on details.
         *
         *    SOLID PRENSİPLERİ (HOCANIN ANLATIMI)
         *    S - Single Responsibility:
         *        Interface, class ve metotlarınız sadece tek bir iş yapmalılar.
         *        Örn:
         *        IMusteriRepository.class -> sadece ve sadece müşteriyle
         *        ilgili olan veri tabanına kaydetme işlemi yapmalı.
         *        ICrud, IService vs. -> sadece DB'ler için işlem bütünlüğünü
         *        sağlıyor.
         *        save(Musteri m, IslemTuru t), findById(),
         *        findOptionalByUsernameAndPassword() -> bir metot sadece bir
         *        iş yapar.
         *    O - Open/Closed:
         *        Yazdığınız metot ve class'lar değişime kapalı olmalı, ancak
         *        gelişime açık olmalı. Metodun halihazırdaki içeriği
         *        değiştirilmemeli. Çünkü eğer değiştirilecekse, o metota bağlı
         *        bütün metotlar, mikroservisler gözden geçirilmek zorundadır
         *        (büyük bir iş yükü).
         *        Services -> findAll(), filter -> active kayıtların yaptığı işlemler
         *        findAll(){filter, silinmiş hesaplar, aktif olmayan hesaplar gösterilmesin}.
         *        Bu bir sorun; başka bir metot içinde silinmiş hesapların
         *        aktivasyonunu raporlamam gerekiyordu, ancak hiç data gelmediği
         *        için sorunu tespit edemedim.
         *        Services -> findAllIsActiveTrue();
         *    L - Liskov Substitution:
         *        Gereksiz metot kullanımlarından uzak durun, mümkün olduğu kadar
         *        ortak kullanılan metotları miras alarak kullanın. Eğer ortak
         *        genişleme yapıları ve metotlar kullanacaksanız Interface miras
         *        alarak genişlemeleri yapınız.
         *        MusteriService, UrunService, SatisService -> save();
         *        ServiceManager<Entity,ID>{ save(); findAll(); }
         *
         *    I - Interface Segregation:
         *        Uygulama içinde sorumluluğu bulunan sınıf ve metotların olabildiğinde
         *        kalıplara uymasını sağlamak isteriz. Bu nedenler interface'lerden
         *        yararlanırız. Ancak, burada dikkat edilmesi gereken bir husus var:
         *        Her sınıf için bir interface değil, aynı görevleri üstlenen sınıflar
         *        için tek bir interface kullanmak doğru olacaktır.
         *
         *    D - Dependency Inversion:
         *        Bir projeyi yaparken, kodlanabilirlik ve kodların azaltılması
         *        adına miras alma yöntemlerini sıklıkla kullanırız. Ancak burda
         *        dikkat edilmez ise kodların bağımlılığı sıkılaşır ve bir süre
         *        sonra sınıfların değişim ve dönüşümleri sorun yaratmaya başlar.
         *        A->
         *        B-A, C-A, G-A
         *        E-G, D-B
         *        ---
         *        MusteriRepositroy, UrunRepository, SatisService
         *        MusteriRepositoryH(Hibernate)
         *        Satis -> Musteri ve Urun -> MusteriRepository mr = new MusteriRepository() [nesne yaratıyo - bağımlı oluyo, böyle olmaması lazım)
         *        ---
         *        Polimorfizm (ÇokBiçimlilik) kullanmalıyız.
         *        ---
         *        Ödeme Sistemi -> KrediKartı, Çek, Nakit, DijitalPara
         *        Islem{
         *           Odeme odeme = new Odeme();
         *           odeme.odemeYap(KrediKartı);
         *        }
         *
         */

    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----
