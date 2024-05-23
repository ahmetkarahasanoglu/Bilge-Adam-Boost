package com.ahmet.throw_odev_sales;

import java.util.Scanner;

public class RunnerSales {
    /**
     * Kendinize özel bir istisna sınıfı oluşturun. Uygulamanız
     * e-ticaret uygulaması.
     * İnsanlar ürünlerin içinde arama yapacaklar. Bu aramalarda,
     * Aradığınız ürün bulunamadı, Böyle bir ürün adı yok, böyle
     * bir fiyat aralığı yok şeklindeki hataları istisna olarak
     * dönen kodları yazınız.
     */

    public static void main(String[] args) {

        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Aradığınız ürünün id'sini giriniz: ");
        int urunId = sc.nextInt();
        sc.nextLine(); // dummy
        if(!isFound) {
            try {
                throw new SalesException(ErrorType.ERROR_NOTFOUND_BYID);
            }catch(Exception e) {
                System.out.println("Hata yakalandı: " + e.toString());
                System.out.println("sonraki satır");
            }

        }

        try {
            System.out.println("Aradığınız ürünün adını giriniz: ");
            String urunIsmi = sc.nextLine();
        }catch(Exception exception) {
            throw new SalesException(ErrorType.ERROR_NO_SUCH_PRODUCT_NAME);
        }

        try {
            System.out.println("Aradığınız fiyat aralığını giriniz: ");
            String fiyatAraligi = sc.nextLine();
        }catch(Exception exception) {
            throw new SalesException(ErrorType.ERROR_NO_SUCH_PRICE_RANGE);
        }

    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE -------
