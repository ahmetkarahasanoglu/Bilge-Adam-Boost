package com.ahmet;

import org.junit.jupiter.api.*;

// junit, mockito -> test yapma ortamlarıdır.

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitOrnekTest {

    /**
     * TEST İŞLEMLERİNİN YAŞAM DÖNGÜSÜ
     */

    private String ad = "Muhammet";

    @BeforeAll // En ilk burası çalışır.
    void initAll() {
        System.out.println("İlk önce ben çalışırım (BeforeAll)");
    }

    @BeforeEach // Her bir test metodu için çalışmadan önce yapılması gereken işlemleri tekrar tekrar yapar.
    void init() {
        ad = "Muhammet";
        System.out.println("BeforeEach çalıştı.");
    }

    @Test
    void EqSayiTesti() {  // test metotlarının geri dönüş tipi void'dir.
        int s1 = 5;
        int s2 = 5;
        Assertions.assertEquals(s1,s2);
        System.out.println("EqSayiTesti çalıştı.");
    }

    @Test
    void TrueTest() {
        Assertions.assertTrue(ad.startsWith("M"));
        System.out.println("TrueTest çalıştı.");
    }

    @AfterEach // Her bir testten sonra tekrar tekrar yapılması gereken işlemleri yapar.
    void finish() {
        System.out.println("Metodun testi bitti.");
    }

    @AfterAll // En son burası çalışır.
    void finishAll() {
        System.out.println("En son ben çalışırım (AfterAll)");
    }

}
