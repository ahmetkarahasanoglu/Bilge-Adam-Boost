package com.ahmet.throw_example;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kümes numarasını giriniz....: ");
        int kumesNo = sc.nextInt();
        System.out.print("Yumurta sayısı.....: ");
        YumurtaUretim yy = YumurtaUretim.Init();
//        System.out.println(yy.yumurtaSay(kumesNo));

        /**
         * Checked Exception metotları nasıl sarmalarız? 2 yöntem var:
         * 1- bulunduğunuz metodun aynı istisnayı fırlatmasını
         *    sağlayarak (burda 'main' metodunun yanına
         *    'throws Exception' yazarak.
         * 2- ilgili metodu try-catch'e alarak sarmalarsınız.
         *    Örneğin:
         */
        try {
            System.out.println(yy.yumurtaSay_Checked(kumesNo));
        }catch(Exception exception) {
            System.out.println("Hata yakalandı (checked exception).");
        }


    }//MAIN ENDS HERE ---------
}//CLASS ENDS HERE --------
