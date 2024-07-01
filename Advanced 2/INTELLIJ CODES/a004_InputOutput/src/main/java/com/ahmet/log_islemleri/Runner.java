package com.ahmet.log_islemleri;

public class Runner {

    public static void main(String[] args) {

        DosyaIslemleri ds = new DosyaIslemleri();

        try {
            int sayi = 9;
            int sayi2 = 0;
            int bolum = sayi / sayi2;
        } catch(Exception exception) {
            System.out.println("Hata yakalandi: " + exception.getMessage());
            ds.createLog(new Log(
                    exception.getMessage(), 1000,
                    "Runner", "main",
                    System.currentTimeMillis(),
                    "İki sayının birbirine bölünme işlemi"
            ));
        }

        System.out.println(ds.getLogFile("f94fec42-54d0-4680-84ec-a7fc9c485858").get().toString());

    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE -------
