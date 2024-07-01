package com.ahmet;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Runner_MusteriArama {

    public static void main(String[] args) {

        System.out.println("*********************************");
        System.out.println("********* MUSTERI ARAMA *********");
        System.out.println("*********************************");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String aranan = "";
        System.out.print("Aradığınız müşteriyi giriniz......: ");
        aranan = sc.nextLine();
        findByName(aranan);


    }//MAIN ENDS HERE ------

    private static void findByName(String name) {
        try{
            Driver.class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbSatis?user=postgres&password=root");
            PreparedStatement pr = connection.prepareStatement("select * from tblmusteri where ad ilike '%"+name+"%'"); // içinde name değişkeninin değeri geçen ad'ları bul
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                String telefon = rs.getString("telefon");
                System.out.println(ad + " " + soyad + " - " + email);
            }
        }catch(Exception e) {
            System.err.println("Bir hata oldu....: " + e.getMessage());
        }
    }

}//CLASS ENDS HERE -----
