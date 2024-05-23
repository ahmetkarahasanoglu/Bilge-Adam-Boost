package com.ahmet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner_ExceptionList {

    public static void main(String[] args) {

        int s1, s2, toplam;
        Scanner sc;
        /**
         * 'throw' komutu:
         * Hanig kodun nasıl bir istisna fırlatacağını nasıl anlarım,
         * nereden bulurum. Kullandığınız metodun içine girerek hata
         * fırlatıp fırlatmadığına bakarsınız. Peki ne arayacağız?
         * 'throw' komutunu kullanmanız yeterlidir.
         */
        boolean isException = false; // 'hata var mı' değişkeni
        do{
            try{
                sc = new Scanner(System.in);
                System.out.println("1. sayıyı giriniz....: ");
                s1 = sc.nextInt();
                System.out.println("2. sayıyı giriniz....: ");
                s2 = sc.nextInt();
                if(s2 == 0) { // my if-block (chat gpt)
                    throw new ArithmeticException("Bölen sıfır olamaz!");
                }
                int bolme = s1 / s2;
                System.out.println("İKi sayının bölümü....: " + bolme);
                isException = false;  // IMPORTANT !!!!!!!!!
            }catch(InputMismatchException exception) {
                System.out.println("Geçersiz giriş! Tamsayı girilmedi! Lütfen geçerli bir tamsayı giriniz!");
                System.out.println("Hata detayı: " + exception.toString());
                isException = true;  // IMPORTANT !!!!!!!!!!
            }catch (ArithmeticException exception) {
                System.out.println("İşlem hatası! Lütfen geçerli değerler giriniz!");
                System.out.println("Hata detayı: " + exception.toString());
                isException = true;  // important !!
            }catch(Exception exception) {  // en sonunda genel bir exception catch'i yazarız.
                System.out.println("Beklenmeyen hata. Lütfen bilgiişlem ile iletişime geçiniz.");
                System.out.println("Hata detayı: " + exception.toString());
                isException = true;
            }finally {
                System.out.println("Her durumda çalışan kısım.");
            }
        }while(isException);
        System.out.println("PROGRAM SONLANDI.");

    }//MAIN ENDS HERE ------

}//CLASS ENDS HERE -----
