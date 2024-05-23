package com.ahmet;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**
         * İSTİSNALARI (HATA YAKALAMA)
         * Syntax:
         * try {
         *  --> hatanın olacağını düşündüğünüz kod bloğunu
         *      buraya yazıyorsunuz.
         * }catch(Exception ex) { --> catch: bir istisna
         *                            olduğu zaman bunu yakalayacak olan kısım
         *  --> yakalanan hata, hata türüne göre işleme tabi
         *      tutulur. İstisnanın türü catch parantezleri
         *      içinde talep edilir. (Exception, RuntimeException vs.)
         *      Bir hata olduğunda ne yapılması gerektiği burada işlenir.
         *  }finally { --> hata olsun ya da olmasın yürütülmesi gereken
         *                 işlemler, adımlar var ise bunlar burada
         *                 kodlanmalıdır.
         *
         */
        System.out.println("*******************************");
        System.out.println("******* HESAP MAKİNESİ ********");
        System.out.println("*******************************");
        System.out.println("1- Toplama");
        System.out.println("2- Çıkartma");
        System.out.println("3- Çarpma");
        System.out.println("4- Bölme");
        System.out.println("0- ÇIKIS");
        Scanner sc = new Scanner(System.in);
        System.out.println("Seçim yapınız.....: ");
        try{
            int secim = sc.nextInt();
        }catch (Exception e) {
            System.out.println("Hata oldu. Geçersiz giriş! Lütfen geçerli bir tamsayı girin.");
        }finally {
            System.out.println("Burası 'finally' bloğu");
        }
        System.out.println("Program sonlandı.");


    }//MAIN ENDS HERE -------

}//CLASS ENDS HERE ------