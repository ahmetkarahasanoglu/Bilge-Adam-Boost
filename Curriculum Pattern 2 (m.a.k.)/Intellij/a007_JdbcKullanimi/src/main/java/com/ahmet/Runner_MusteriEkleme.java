package com.ahmet;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Runner_MusteriEkleme {

    public static void main(String[] args) {

        System.out.println("*******************************");
        System.out.println("******* MÜŞTERİ EKLEME ********");
        System.out.println("*******************************");
        System.out.println();;

        String ad, soyad, email, telefon, cinsiyet;
        int yas;
        Scanner sc = new Scanner(System.in);
        System.out.print("Müşteri adı................: ");
        ad = sc.nextLine();
        System.out.print("Müşteri soyadı.............: ");
        soyad = sc.nextLine();
        System.out.print("Müşteri email..............: ");
        email = sc.nextLine();
        System.out.print("Müşteri telefon............: ");
        telefon = sc.nextLine();
        System.out.print("Müşteri cinsiyet...........: ");
        cinsiyet = sc.nextLine();
        System.out.print("Müşteri yaşı...............: ");
        yas = sc.nextInt();

        save(ad,soyad,telefon,email,cinsiyet,yas);
        System.out.println("KAYIT BAŞARI İLE EKLENDİ.");

    }//MAIN ENDS HERE -------

    private static void save(String ad, String soyad, String email, String telefon, String cinsiyet, int yas) {
        /**
         * String ifadeleri birleştirirken aralarına + koymak gereklidir.
         */
        String ifade1 = "Selam";
        String ifade2 = "ben Ahmet";
        String birlestirilmis = ifade1 + " - " + ifade2 + " - ";
        try {
            Driver.class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbSatis?user=postgres&password=root");
            String SQL_INSERT = "insert into tblmusteri(ad,soyad,email,telefon,cinsiyet,yas) " +
                    "values('"+ad+"','"+soyad+"','"+email+"','"+telefon+"','"+cinsiyet+"',"+yas+")";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.executeUpdate();
            connection.close();
        }catch(Exception exception) {
            System.out.println("Bir hata oldu....: " + exception.getLocalizedMessage());
        }
    }

}//CLASS ENDS HERE ------
