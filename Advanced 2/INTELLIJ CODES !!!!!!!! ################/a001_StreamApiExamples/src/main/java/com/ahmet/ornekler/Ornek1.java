package com.ahmet.ornekler;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Ornek1 {

    public static void main(String[] args) {

        List<String> liste = List.of("Ocak", "Subat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık");
        /**
         * SORU:
         * içinde 'a' harfi geçmeyen ayların listesini
         * yazdıran komutu yazınız:
         */
        List<String> aGecmeyen =
                liste
                .stream()
                .filter(x -> !x.toLowerCase().contains("a"))
                        .collect(Collectors.toList());
        System.out.println(aGecmeyen);
        System.out.println("2)-------------------------------");

        /**
         * SORU:
         * Aşağıdaki listede tekrar etmeyen kayıtları listeleyerek z'den a'ya sıralayınız.
         */
        liste = List.of("Ahmet", "Ali", "Canan", "Tekin", "Ülkü", "Hayri", "Deniz", "Eren", "Kaan", "Canan", "Deniz", "Ali");
        liste.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println();
        // or, we can do it by not using 'distinct()', and using 'Set':
        liste.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();
        System.out.println("3)-------------------------------");


        /**
         * SORU:
         * İçerisinde 'a' harfi (büyük veya küçük) içeren isimleri
         * K(Integer), V(List<String>) olacak şekilde Map
         * yapan kodu yazınız. (Key: string uzunluğu,
         * Value: o uzunluktaki elemanlar)
         */
        liste = List.of("Ahmet", "Ali", "Muhammet", "Canan", "Tekin", "Ülkü", "Hayri", "Deniz", "Eren", "Kaan", "Canan", "Deniz", "Ali");
        liste.stream()
                .filter(x -> x.toLowerCase().contains("a"))
                .collect(Collectors.groupingBy(String::length))
                .forEach((k,v) -> System.out.println(k + " --> " + v));



    }//MAIN ENDS HERE -------

}//CLASS ENDS HERE -------
