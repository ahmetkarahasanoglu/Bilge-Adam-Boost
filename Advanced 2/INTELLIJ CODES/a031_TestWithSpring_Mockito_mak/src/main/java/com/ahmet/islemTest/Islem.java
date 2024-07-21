package com.ahmet.islemTest;

public class Islem {

    public int toplam(int s1, int s2) throws Exception {
        int toplam = s1 + s2;
        System.out.println("Burası Islem.class -> toplamMethod'u. Toplam yapıldı....: " + toplam);
        if(s1>s2) {
            throw new Exception("Bilerek hata yaptım");
        }
        return toplam;
    }

}
