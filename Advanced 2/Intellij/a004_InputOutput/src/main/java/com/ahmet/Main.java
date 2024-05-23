package com.ahmet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * dosyanın yolu -> c:\logdata\
         * dosyanın adı -> [AD].[UZANTI] -> hata.log / ASarkı.mp3 / film.mp4 / gezi.jpg / notlar.docx
         */
        String fileUrl = "e:\\LogData\\";
        File file = new File(fileUrl + "sistem.log");
//        try {
//            if (file.createNewFile()) {
//                System.out.println("Dosya oluşturuldu.");
//            } else {
//                System.out.println("Dosya zaten mevcut.");
//            }
//            System.out.println("Dosya var mı...........: " + file.exists());
//            System.out.println("Dosya tam yolu.........: " + file.getAbsolutePath());
//        } catch (IOException e) {
//            System.out.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
//        }

        /**
         * Gerekli olduğunda dosyayı oluşturabilirsiniz.
         * Genellikle 'File', var olan dosyalarımız üzerinde işlem
         * yapmak için kullanılır.
         */
        System.out.println("Dosya var mı...........: " + file.exists());
        System.out.println("Dosya tam yolu.........: " + file.getAbsolutePath());
        System.out.println("Dosya adı..............: " + file.getName());
        System.out.println("Dosyanın konumu........: " + file.getParent()); // tam yolu (sondaki dosya ismi hariç) verir
        System.out.println("Bu bir dosya mıdır.....: " + file.isFile());
        System.out.println("Boyut - byte...........: " + file.length());
        System.out.println("Son değiştirilme zamanı: " + file.lastModified());

        // Bilgi: string içerisinde çift tırnak (") kullanmak
        // için  \"  yazmak gerekir (tırnağın başına \ konur).

        String fileUrl2 = "e:\\LogData\\";
        Path path = Path.of("e:/LogData/sistem.log");
        /**
         * Dosya işlemlerini yönetmek için Files kullanılır. Yaygındır.
         * Dosya kopyalama
         * Dosya silme
         * Dosyayı sorgulama işlemleri için kullanılır.
         */
        System.out.println("Files - Dosya var mı....: " + Files.exists(path));

//        path = Path.of("e:/LogData/resim.bmp");
        /**
         * Dosya işlemleri yapılırken, dosya adlarının yanlış
         * yazılması ya da var olmayan dosyaların üzerinde işlem
         * yapılmaya çalışılması sorunlara neden olacaktır. Bu
         * nedenle dosya işlemlerinde exception kullanılır.
         */
//        Files.setAttribute(path, "dos:readonly", false); // path'deki dosyanın salt okunur (read only) olmasını iptal eder.
//        Files.setAttribute(path, "dos:hidden", false); // path'deki dosyanın gizliliğini kaldırır.

//        Files.delete(path);  // dosya var ise siler, yoksa hata fırlatır. 'delete' bir checked exception olduğu için ya try-catch kullanılmalı, yada içinde bulunduğu metod(burda main metodu)'un yanına 'throws ....Exception' yazılmalı. try-catch daha mantıklı ve kullanışlı.
//        Files.deleteIfExists(path); // dosya var ise siler, yoksa bir şey yapmaz.

//        Files.copy(path, Path.of("e:/LogData/sistem_yedek.log")); // dosyayı belirtilen hedefe kopyalar, dosya zaten orda var ise hata fırlatır.
//        Files.copy(path, Path.of("e:/LogData/sistem_yedek.log"), REPLACE_EXISTING); // eğer dosya hedefte zaten var ise, üzerine yaz.
        Files.move(path, Path.of("e:/LogData/yedek/sistem_move.log")); // taşıma yapar. Dosyanın ismini de değiştirebiliyoruz adres içeriğinde.

        /**
         * '--> DİKKAT!!!: kopyalarken 'REPLACE_EXISTING' kullanırsak
         * parametre olarak; eğer hedefteki dosya bizim aynı isim ile
         * kaydettiğimiz başka bir dosya ise, onun üzerine yazar ve
         * o dosyayı kaybederiz.
         */



    }//MAIN ENDS HERE -------

}//CLASS ENDS HERE ------