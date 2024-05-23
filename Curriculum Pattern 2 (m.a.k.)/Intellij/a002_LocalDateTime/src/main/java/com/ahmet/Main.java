package com.ahmet;
import com.ahmet.constants.MyDateTime;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /**
         * LOCAL DATE TIME KULLANIMI
         * 1- kullanıcıların ya da müşterilerin doğum tarihleri
         * 2- ürünlerin skt'leri.
         * 3- kayıt ettiğimiz verilerin oluştururlma ve
         * güncellenme zamanları.
         *    Zaman damgası için Long kullanımı yaygındır.
         * - createDate -> Long -> 01.01.1970 tarihini başlangıç
         * kabul ederek o zamandan şu anki zamana kadar olan
         * süreyi long olarak hesaplamaktadır.
         * 1000ms   -> 1sn
         * 60sn     -> 1dk
         * 60dk     -> 1sa
         * 24sa     -> 1gün
         *
         * static final Long 3d = 1000L*60*60*24*3;
         * Su anki zaman -> System.currentTimeMillis();
         *
         */
        System.out.println("Su anki zaman - System.currentTimeMillis()....: " + System.currentTimeMillis());
        /**
         * Date -> tarih
         * Date kullanımı java'da artık tarih olma üzere, birçok metodu
         * kullanılamayacak.
         *      @Deprecated -> bir metod'un ilerleyen java versonlarında
         * desteklenmeyeceğini anlatır. Böyle bir durumda ilerleyen
         * zamanlarda java versiyonunuzu güncellerseniz, uygulamanız
         * çalışmayacaktır. Date olarak kullandığınız tüm kodları
         * değiştirmek zorunda kalacaksınız demektir.
         */
        Date date = new Date();
        System.out.println("Date date = new Date() --> date: " + date);
        System.out.println("Local Time.............: " + LocalTime.now());
        System.out.println("Local DateTime.........: " + LocalDateTime.now());
        System.out.println("Nano (atomik) zaman....: " + System.nanoTime());
        /**
         * LocalDate -> of(year,month,day)
         * LocalTime -> of(hour, minute, second, nanotime->(00000000000)
         */
        LocalDate localDate = LocalDate.of(2025, 5, 20);
        localDate = LocalDate.of(2033, Month.NOVEMBER, 18);
        System.out.println("Elle Zaman Tanımlama....: " + localDate.toString());
        LocalTime localTime = LocalTime.of(5,25,58);
        System.out.println("Local Time....: " + localTime.toString());
        ZonedDateTime zonedDateTime = ZonedDateTime
                .of(2023, 1,3,
                        10, 15, 36, 221111,
                        ZoneId.of("Europe/London"));
        System.out.println(ZonedDateTime.now());
        System.out.println(zonedDateTime);
        System.out.println("3)------------------------------------");

        /**
         * LocalDate, Time Manipülasyonları ve Period Kullanımı:
         */
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Gün olarak 10 gon sonrası....: ");
        System.out.println(localDate1.plusDays(10));
        System.out.println("Hafta olarak 2 hafta sonrası....: ");
        System.out.println(localDate1.plusWeeks(2));
        System.out.println("Ay olarak 2 ay öncesi....: ");
        System.out.println(localDate1.minusMonths(2));
        System.out.println("4)------------------------------------");

        /**
         * Eklenilecek zaman dilimi, gün-ay-hafta-yıl vs.
         * olabiliyorken her işlem için ayrı ayrı kontrol
         * sağlama gerekecek.
         * DİKKAT!!!!
         * Mevcut zamana ait işlemlerde, plus, minus vs. hiç
         * birisi zamanı değiştirmez. Sadece işlem yapıldığı
         * metot, eklediği ya da çıkarttığı zamanı döner. Or-
         * jinal zaman değişkenimizi değiştirmez ('localDate1'
         * gibi). Ancak eğer '=' ile atama işlemi yaparsak
         * değişir.
         */
        Period period = Period.ofWeeks(6);
        System.out.println("Mevcut date...: " + localDate1);
        System.out.println("Period kullanımı....: " + localDate1.plus(period));
        System.out.println("Mevcut date....: " + localDate1);
        System.out.println("5)------------------------------------");
        /**
         * Zamanı takip etmek
         */
        Long start_ms = System.currentTimeMillis();
        Long start_nn = System.nanoTime();
        Instant start_ins = Instant.now();
        long toplam = 0;
        for(int i=0; i<20_000_000_000l; i++) {
            toplam++;
        }
        System.out.println("Toplam....: " + toplam);
        Long end_ms = System.currentTimeMillis();
        Long end_nn = System.nanoTime();
        Instant end_ins = Instant.now();
        System.out.println("Milisaniye....: " + (end_ms-start_ms));
        System.out.println("Nanosaniye....: " + (end_nn-start_nn));
        Duration duration = Duration.between(start_ins, end_ins);
        System.out.println("Inst Mili....: " + duration.getSeconds());
        System.out.println("Inst Nano....: " + duration.getNano());
        System.out.println("Inst Mili....: " + duration.toMillis());
        System.out.println("Inst Nano....: " + duration.toNanos());
        System.out.println("6)------------------------------------");

        /**
         * static Hazır zaman dilimlerimizi kullanmak:
         */
        LocalDate localDate2 = LocalDate.now();
        Date date1 = new Date();
        /**
         * DİKKAT !!!
         * zaman dilimlerinizi hangi sayısal değerler üzerinden
         * kurguladığınıza dikkat edin. Zira aşağıda yazdığım
         * şekil hatalıdır:
         */
//        System.out.println("Hatalı yazım: " + localDate2.plusDays(MyDateTime.YEDIGUN)); // 'plusDays' expects a number as a parameter. But our parameter's value is very very big: 1000*60*60*24*7

        // Şu anki zaman:
        Long now = System.currentTimeMillis();
        Long newtime = now+MyDateTime.YEDIGUN;
        System.out.println(new Date(newtime));

    }//MAIN ENDS HERE -------

}//CLASS ENDS HERE -----