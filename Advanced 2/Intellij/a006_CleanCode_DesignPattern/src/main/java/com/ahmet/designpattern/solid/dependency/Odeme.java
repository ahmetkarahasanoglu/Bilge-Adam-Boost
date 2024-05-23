package com.ahmet.designpattern.solid.dependency;

public class Odeme {

    // --- Yanlış Kullanım:
//    public void odemeYap(KrediKarti krediKarti) {  // Yanlış kullanım
//        System.out.println(krediKarti.id + " ile ödeme yapıldı.");
//    }

    public void odemeYap(IOdemeYontemi yontem) {
        System.out.println("Ödeme yapıldı.");
    }

}
