package com.ahmet;

import com.ahmet.islemTest.Islem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*; // her seferinde 'Mockito.' yazmamak için Mockito'yu import ettik (static olarak)

public class MockitoOrnek {

    @Test
    void test1() {
        List<String> isimler = new ArrayList<>(); // new ArrayList<>()  yerine  mock(List.class)  yazdık.
        isimler.add("Ahmet");
        isimler.add("Canan");
        isimler.forEach(System.out::println);
    }

    @Test
    void test1_Mock() {
        List<String> isimler = mock(List.class); // new ArrayList<>()  yerine  mock(List.class)  yazdık. ||| 'isimler' is a mock object. The below 'add' operations do not actually store the elements. Mockito just records that these methods were called with the specified arguments.
        isimler.add("Ahmet");                    // '--> kullandığımız 'mock': bir sınıfı taklit eden bir yapısı vardır ve taklit ettiği sınıfın sadece metotlarını barındırır.
        isimler.add("Canan");                    // '--> Oluşan nesne içinde arayüzler vardır, ancak işlevleri yoktur. Gerekli olduğunda bu işlevleri siz tanımlarsınız.
        isimler.forEach(System.out::println);    // '--> bu 'add' işlemleri geçersizdir, listeye ekleme yapamazlar. Biz sadece arayüzlerini (metot heading'ini) görüyoruz, gövdesinde işlem yapacak kod yoktur.
        System.out.println("İŞLEM BİTTİ.");
    }

    // ------

    @Test
    void islemTest() throws Exception {
        Islem islem =  new Islem();
        int toplamBilgisi = islem.toplam(12,6); // burda, test yaptığımız sınıfın dışındaki başka bir sınıftan ('Islem' sınıfı) gelen hata bizim testimizin 'FAIL' olmasına sebep oluyor. Bu yüzden haricî kodları mock'lamamız gerekiyor.
        int kare = toplamBilgisi * toplamBilgisi;
        System.out.println("kare......: " + kare);
    }

    @Test
    void islemTest_Mock() throws Exception {
        Islem islem =  mock(Islem.class); // new Islem()  yerine  mock(Islem.class)  yazdık.
        int toplamBilgisi = islem.toplam(12,6); // 'Islem' sınıfındaki 'toplam()' metodunun gövdesi yokmuş gibi olur (mock'ladığımız için)
        int kare = toplamBilgisi * toplamBilgisi;
        System.out.println("kare......: " + kare);
    }

    // ------

    @Test
    void islemTest_assertions() throws Exception {
        Islem islem =  new Islem();
        int toplamBilgisi = islem.toplam(5,15); // burda, test yaptığımız sınıfın dışındaki başka bir sınıftan ('Islem' sınıfı) gelen hata bizim testimizin 'FAIL' olmasına sebep oluyor. Bu yüzden haricî kodları mock'lamamız gerekiyor.
        int kare = toplamBilgisi * toplamBilgisi;
        System.out.println("kare......: " + kare);
        Assertions.assertTrue(kare==400);

    }

    @Test
    void islemTest_Mock_assertions() throws Exception {
        Islem islem =  mock(Islem.class); // new Islem()  yerine  mock(Islem.class)  yazdık.
        int toplamBilgisi = islem.toplam(12,8); // 'Islem' sınıfındaki 'toplam()' metodunun gövdesi yokmuş gibi olur (mock'ladığımız için)
        int kare = toplamBilgisi * toplamBilgisi;
        System.out.println("kare......: " + kare);
        Assertions.assertTrue(kare==400);
    }

    // ------

    @Test
    void islemTest_Mock_inserValue() throws Exception {
        Islem islem =  mock(Islem.class); // new Islem()  yerine  mock(Islem.class)  yazdık.
        // INSERTING VALUE: Eğer 'işlem' sınıfının 'toplam' metodu (12,8) değerleriyle çağrılırsa 20 değerini dön:
        when(islem.toplam(12,8)).thenReturn(20);
        int toplamBilgisi = islem.toplam(12,8); // 'Islem' sınıfındaki 'toplam()' metodunun gövdesi yokmuş gibi olur (mock'ladığımız için)
        int kare = toplamBilgisi * toplamBilgisi;
        System.out.println("kare......: " + kare);
        Assertions.assertTrue(kare==400);
    }

}
