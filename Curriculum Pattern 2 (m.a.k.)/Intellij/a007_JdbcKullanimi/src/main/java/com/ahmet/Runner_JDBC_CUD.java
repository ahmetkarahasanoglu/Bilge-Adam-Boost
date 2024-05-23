package com.ahmet;

import org.postgresql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Runner_JDBC_CUD {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * JDBC kullanımında ilk yapılması gereken iki sistem
         * arasında köprü görevi görecek olan (tercüman) Driver'ın
         * kullanıma alınmasıdır.
         * 1- Kullanılan veritabanına uygun jdbc driver eklenmelidir.
         * 2- Eklenen driver devreye alınmalıdır.
         */
        Driver.class.forName("org.postgresql.Driver");
        /**
         * Driver'ın ihtiyaç duyduğu parametreler:
         * -> IP Adresi: Bağlantı yapılacak veritabanın sunucusunun IP adresi
         * -> Port Numarası: Hangi port üzerinde yayın yapıyor ise port numarası.
         * -> Veritabanı adı: İşlem yapılacak olan veritabanının adı
         * -> Kullanıcı adı ve şifre: Yetkilendirme için.
         * SQLConnectionString (Bağlantı Cümlesi):
         * DİKKAT !!! Tüm sistemlerde (dillerde) veri tabanına bağlantı
         * işlemlerinde bağlantı cümlesi (SQLConnectionString) kullanılır.
         * Arama yaparken bunu kullanınız.
         * Eğer kendi pc'nizin postgresql'ine bağlanacaksanız:
         * - localhost (127.0.0.1)
         */
        String baglantiAdresi = "jdbc:postgresql://localhost:5432/DbSatis";
        String kullaniciAdi = "postgres";
        String sifre = "root";
        Connection connection = DriverManager.getConnection(baglantiAdresi, kullaniciAdi, sifre);
        /**
         * SQL cümlesi vererek işlenmesini sağlıyoruz:
         */
//        String SQL = "insert into tbladres(musteriid, il, ilce, mahalle, adres)\n" +
//                "values(51, 'İstanbul', 'Kadıköy', 'Caminin yanı', 'İstanbulda bir yerler')";
//        String SQL_DELETE = "delete from tbladres where id=44";
        String SQL_UPDATE = "update tbladres set musteriid=455, il='İZMİR' where id=33";
        /**
         * Hazırladığınız SQL cümlesini Driver'ın taşıyabileceği hale
         * getirmeniz, bir zarfa koymanız gerekli. Bunun için Java'da
         * cümle hazırlayıcısı kullanılır:
         */
        PreparedStatement pre = connection.prepareStatement(SQL_UPDATE);
        /**
         * Sürücüye hazırladığımız emri uygulaması gerektiğini
         * belirtmeliyiz. Hazırlanan cümlenin execute edimesini
         * sağlamalıyız.
         */
        pre.executeUpdate();
        /**
         * Tüm işlemler sona erdikten sonra multaka açılan bağlantının
         * sonlandırılması gerekmektedir. Çünkü bir database connection
         * havuzunda bir PC için 10 bağlantı sağlar. Sonraki bağlantılar
         * reddedilir.
         */
        connection.close();

    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE ------
