package com.ahmet.ozel_istisnalar;

import java.util.Scanner;

public class Runner {
    /**
     * Öğrenci Takip
     * Öğrenci ekleme, güncelleme, listeleme işlemleri
     * Burada oluşan hataların bize özel olarak tanımlanmasını
     * sağlayalım.
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bir sayı gir...: ");
        try {
            int sayi = sc.nextInt();
        }catch(Exception exception) {
            throw new OgrenciException(ErrorType.ERROR_NOTFOUND_BYID);
        }

    }//MAIN ENDS HERE -------

    /**
     * Bir kullanıcıyı id'sine göre aramak.
     * -> aradığın kişi yok
     * -> hata
     * -> beklenmeyen bir durum oldu.
     */


}
