package com.ahmet;

import java.sql.SQLOutput;

public class SleepKullanimi {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("İşlemler başladı, lütfen bekleyiniz...");
        Thread.sleep(3_000);
        System.out.println("Beklediğiniz için teşekkürler. İşlemler aktif.");
        for(int i=0; i<10; i++) {
            System.out.print(". ");
            Thread.sleep(1_000);
        }
        System.out.println();
        System.out.println("İşlem sonlandı.");


    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----
