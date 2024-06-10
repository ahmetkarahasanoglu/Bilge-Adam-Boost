package com.ahmet.Java6XmlConfiguration.xml.databaseornek;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1- Postgre ve Mysql sınıfımız olsun.
 * 2- DatabaseService sınıfımız olsun.
 * 3- Postgre ve Mysql'de database log'lama metotlarımız olsun
 *    (Postgre'ye loglandı, Mysql'e loglandı)
 * 4- DatabaseService'te de logToDatabase metodumuz olsun, hangi
 *    database'i kullanıyorsak onun log metoduna erişsin.
 * 5- Bunun için bir applicationContext yazalım ve DatabaseTest
 *    sınıfımızda test edelim.
 */
public class DatabaseTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("databaseContext.xml");
        DatabaseService databaseService = context.getBean("databaselogger", DatabaseService.class);
        databaseService.log();

    }

}
