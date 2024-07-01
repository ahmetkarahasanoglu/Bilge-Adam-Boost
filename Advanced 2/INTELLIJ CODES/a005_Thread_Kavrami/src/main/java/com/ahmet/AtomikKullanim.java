package com.ahmet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomikKullanim {

    public static void main(String[] args) {

        List<String> isimler =
                List.of("Ali", "Ahmet", "Ayşe", "Aynur", "Ayhan", "Bahar", "Belçim");
        /**
         * Bir listeyi
         * For ile
         * forEach ile
         * foreach()
         */
        int toplam = 0;
        System.out.println("For ");
        for(int i=0; i<isimler.size(); i++) {
            toplam += isimler.get(i).length();
            System.out.println(isimler.get(i));
        }
        System.out.println("Toplam uzunluk.....: " + toplam);
        System.out.println("-------------------------------");
        System.out.println(".forEach");
        /**
         * AtomicInteger nedir? Atomic'ler nedir?
         * forEach içinde primitive ve çoklu işlem tarafından erişim
         * olabilecek türde değişkenlerle işlem yapamazsınız. Bunun
         * yerine, List, Iterable gibi değişken türleri,
         * final ile işaretlenmiş değişmeyen türler kullanabilirsiniz.
         * Eğer üzerinde çalışmanız gereken bir değişken var ise,
         * Atomic olarak kullanmak doğru olacaktır.
         * AtomicInteger, Boolean vs.
         */
        AtomicInteger toplamUzunluk = new AtomicInteger(0);
        toplamUzunluk.incrementAndGet(); // ++i;
        toplamUzunluk.getAndIncrement(); // i++;
        toplamUzunluk.decrementAndGet(); // --i;
        toplamUzunluk.getAndDecrement(); // i--;
        final String ad = "ali", telefon="0 555 666 77 88"; // forEach içerisinde kullanılacak ve değişmeyecek değişkenleri 'final' yapmalıyız.
        final int yas = 43;
        isimler.forEach((x -> {
            String birlestir = ad + telefon + yas;
            toplamUzunluk.set(toplamUzunluk.get() + x.length());
            System.out.println(x);
        }));

    }//MAIN ENDS HERE ------

}//CLASS ENDS HERE -----
