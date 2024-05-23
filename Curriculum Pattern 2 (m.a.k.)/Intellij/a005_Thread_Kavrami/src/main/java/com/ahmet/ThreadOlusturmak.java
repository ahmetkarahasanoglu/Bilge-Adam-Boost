package com.ahmet;

public class ThreadOlusturmak {

    public static void main(String[] args) {
        /**
         * Thread direkt çalışabilir.
         * Fakat Runnable bir thread içinde start edilmelidir.
         */
        Deger deger = new Deger();
        deger.sayi = 20;
        MyThread myThread = new MyThread(deger); // ikisi de aynı 'deger' objesiyle çalışacak (bu ve alttaki)
        MyRunnable myRunnable = new MyRunnable(deger);
        Thread mt = new Thread(myRunnable);
        mt.start();
        myThread.run();


    }//MAIN ENDS HERE -----

}//CLASS(ThreadOlusturmak) ENDS HERE ---

class Deger {
    int sayi;
}

class MyThread extends Thread {
    Deger d;
    public MyThread(Deger d) {  // constructor
        this.d = d;
    }
    public void run() {         // method description
        for(int i=0; i<100; i++) {
            d.sayi++;
            System.out.println("MyThread......: " + d.sayi);
        }
    }
}

class MyRunnable implements Runnable {
    Deger d;
    public MyRunnable(Deger d) { // constructor
        this.d = d;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            d.sayi--;
            System.out.println("MyRunnable......: " + d.sayi);
        }
    }
}
