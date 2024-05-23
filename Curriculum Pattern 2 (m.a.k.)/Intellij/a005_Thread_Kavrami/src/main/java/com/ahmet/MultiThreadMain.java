package com.ahmet;

public class MultiThreadMain {

    public static void main(String[] args) {

        /**
         * Main Thread
         */
        long start = System.currentTimeMillis();
        new Thread(() -> {
            long toplam1 = 0;
            for(long i=0; i<10_000_000_000L; i++) {
                toplam1++;
            }
            System.out.println("toplam1.....: " + toplam1);
        }).start();

        new Thread(() -> {
            long toplam1 = 0;
            for(long i=0; i<10_000_000_000L; i++) {
                toplam1++;
            }
            System.out.println("toplam2.....: " + toplam1);
        }).start();

        new Thread(() -> {
            long toplam1 = 0;
            for(long i=0; i<10_000_000_000L; i++) {
                toplam1++;
            }
            System.out.println("toplam3.....: " + toplam1);
        }).start();

        new Thread(() -> {
            long toplam2 = 0;
            for(long i=0; i<10_000_000_000L; i++) {
                toplam2++;
            }
            System.out.println("toplam4.....: " + toplam2);
        }).start();

        long end = System.currentTimeMillis(); // Thread'ler daha bitmeden burası çalışıyor; dolayısıyla toplam işlem süresi (6 milisaniye çıkıyor), doğru hesaplanmıyor.
        System.out.println("Toplam işlem süresi: " + (end - start) + " milisaniye.");

    }//MAIN ENDS HERE ------

}//CLASS ENDS HERE -----