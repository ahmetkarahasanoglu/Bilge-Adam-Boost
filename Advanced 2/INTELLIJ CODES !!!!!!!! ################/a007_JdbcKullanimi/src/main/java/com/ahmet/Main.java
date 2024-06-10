package com.ahmet;

import org.postgresql.Driver;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Driver.class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbSatis?user=postgres&password=root"); // Tek satırda da yazabiliyoruz bu şekilde bütün bilgileri.
        PreparedStatement pr = connection.prepareStatement("select * from tblmusteri order by id");

        /**
         * SQL sorguları neticesinde bir tablo dönüşü olacak ise,
         * resultSet şeklinde tablo olarak döner. Burada önemli olan
         * bu resultSet içindeki dataların satır satır okunması
         * gerektiğidir.
         */
        ResultSet resultSet = pr.executeQuery(); // 'pr.executeQuery()' returns a ResultSet object that contains the data produced by the query, (never null).
        /**
         * Satır satır okuma işlemini while ile yaparız. Çünkü
         * resultSet içinde bulunan 'next()' metodu her seferinde
         * bir satıra odaklanır.
         */
        while(resultSet.next()) { // [checking if there is a next line in the table of sql]. 'next()' method: returns 'true' if the new current row is valid; 'false' if there are no more rows
            /**
             * resultSet, içinde bulunan metotlar ile tablo satırı
             * içindeki kolonları seçebilir. Burada dikkat edilecek
             * nokta, okumaya çalıştığınız sütunun tipi (long, int,
             * string vs.)'dir. Ayrıca okuyacağınız tablo sütununun
             * ya index numarasını ya da adını vermeniz gereklidir
             * (en soldaki kolonun index'i 1'den başlar, sağa doğru
             * devam eder).,
             */
            // İki erişim şekline de örnek verelim:
            long id = resultSet.getLong("id"); // (en soldaki kolonun adı "id" kolonu). pay att: we set the variable type 'long' - the same type with the database column's data
            String ad = resultSet.getString(2); // 2'nci kolon ("ad" kolonu). pay att: we set the variable type 'String' - the same type with the database column's data
            System.out.println("id....: " + id + " - ad....: " + ad); // veritabanımızdaki 1000 tane müşterinin id ve ad'ını yazdırsın.
        }
        connection.close();

    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE ------
