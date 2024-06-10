package com.ahmet;

import com.ahmet.controller.UserProfileController;

import java.util.Scanner;

public class TwitterApp {

    public static void main(String[] args) {

        int secim = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********************************");
            System.out.println("*********** TWITTER APP **********");
            System.out.println("**********************************");
            System.out.println();
            System.out.println("1- Üye Ol");
            System.out.println("2- Giriş Yap");
            System.out.println("3- Tweet'leri Gör");
            System.out.println("0- ÇIKIS YAP");
            System.out.print("Seçim yapınız: ");
            secim = Integer.parseInt(scanner.nextLine());
            switch(secim) {
                case 1:
                    new UserProfileController().register();
                    break;
                case 2:
                    new UserProfileController().login();
                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor.");
                    break;
            }
        }while(secim!=0);
        System.out.println("TEKRAR GÖRÜSMEK ÜZERE.");

    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----