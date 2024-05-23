package com.ahmet;

import com.ahmet.controller.AracController;
import com.ahmet.controller.KiralamaController;
import com.ahmet.controller.KisiController;
import com.ahmet.repository.AracRepository;
import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kiralama;
import com.ahmet.repository.entity.Kisi;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/*
Bir Araç Kiralama Uygulaması yazınız.
1- Tablolar (Araç, Kişi, Kiralama)
2- Menüler (Ana Menü, Araç Ekleme, Araç Arama, Kişi Ekleme,
   Kiralama, Rapor)
3- Raporlar
   a- Şu an kirada olan araçlar
   b- Boşta olan araçlar
   c- Herhangi bir müşterinin kiraladığı araçlar
Yukarıda belirtilen maddelerin olduğu uygulamayı hibernate
kullanarak, katmanlı yapıya uygun olarak kodlayınız.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    KisiController kisiController = new KisiController();
    AracController aracController = new AracController();
    KiralamaController kiralamaController = new KiralamaController();

    public static void main(String[] args) {

        Main main = new Main();
        main.anaMenu();

    }//MAIN ENDS HERE ----

    public void anaMenu() {
        int input = 0;
        do {
            System.out.println("====== ARAÇ KİRALAMA SİSTEMİ ======");
            System.out.println("1- Araç Ekle");
            System.out.println("2- Araç Ara");
            System.out.println("3- Kişi Ekle");
            System.out.println("4- Araç Kirala");
            System.out.println("5- Raporlama Menüsü");
            System.out.println("0- ÇIKIŞ");
            System.out.print("Lütfen seçim yapınız: ");
            input = Integer.parseInt(scanner.nextLine());

            switch(input) {
                case 1:
                    aracEkle();
                    break;
                case 2:
                    aracAra();
                    break;
                case 3:
                    kisiEkle();
                    break;
                case 4:
                    kiralamaYap();
                    break;
                case 5:
                    raporlamaMenusu();
                    break;
            }

        }while(input!=0);
    }

    private void raporlamaMenusu() {
        int input = 0;
        do{
            System.out.println("==== Raporlama ====");
            System.out.println("1- Şu an kirada olan araçlar");
            System.out.println("2- Boşta olan araçlar");
            System.out.println("3- Herhangi bir müşterinin kiraladığı araçlar");
            input = Integer.parseInt(scanner.nextLine());
            switch(input) {
                case 1:
                    kiradaOlanAraclar();
                    break;
                case 2:
                    bostaOlanAraclar();
                    break;
                case 3:
                    musteriyeGoreKiraladigiAraclar();
                    break;
            }
        }while(input!=0);
    }

    private void musteriyeGoreKiraladigiAraclar() {
        System.out.println("Lütfen müşteri Id'si giriniz: ");
        Long kisiId = Long.parseLong(scanner.nextLine());
        Kisi kisi = kisiController.findById(kisiId);
        kisi.getKiralamalar().forEach(x -> System.out.println(x.getArac()));
    }

    private void bostaOlanAraclar() {
        System.out.println("--- Boşta Olan Araçlar ---");
        aracController.findAllByDurum(false).forEach(System.out::println);
    }

    private void kiradaOlanAraclar() {
        System.out.println("--- Kirada Olan Araçlar ---");
        aracController.findAllByDurum(true).forEach(System.out::println);
    }

    private void aracAra() {
        System.out.println("--- Araç Arama ---");
        System.out.print("Aracın markasını giriniz: ");
        String marka = scanner.nextLine();
        System.out.print("Aracın modelini giriniz: ");
        String model = scanner.nextLine();
        System.out.println(aracController.findByMarkaAndModel(marka, model));
    }

    private void kisiEkle() {
        System.out.println("--- Kişi Ekleme ---");
        System.out.print("İsminizi giriniz: ");
        String name = scanner.nextLine();
        System.out.print("Kullanıcı adınızı giriniz: ");
        String username = scanner.nextLine();
        System.out.print("Sifrenizi giriniz: ");
        String password = scanner.nextLine();
        System.out.println(kisiController.save(name, username, password));
        System.out.println("- Kişi kayıt edildi.");
    }

    private void aracEkle() {
        System.out.print("Eklemek istediğiniz aracın markasını giriniz: ");
        String markaInput = scanner.nextLine();
        System.out.print("Aracın modelini giriniz: ");
        String modelInput = scanner.nextLine();
        System.out.println(aracController.save(markaInput, modelInput));
        System.out.println("- Araç kayıt edildi.");
    }

    private void kiralamaYap() {
        List<Arac> aracList = aracController.findAllByDurum(false);
        if(aracList.isEmpty()) {
            System.out.println("Kiralanabilecek araç kalmadı!");
        }else {
            System.out.println("Kiralanabilecek Araçlar Aşağıdadır:");
            aracList.forEach(System.out::println);
            System.out.print("Kiralamak istediğiniz aracın id'sini giriniz: ");
            Long arac_id = Long.parseLong(scanner.nextLine());
            Arac arac = aracController.findById(arac_id);
            System.out.print("User id'nizi giriniz: ");
            Long userId = Long.parseLong(scanner.nextLine());
            Kisi kisi = kisiController.findById(userId);
            System.out.print("Kaç gün kiralanacağını giriniz: ");
            int day = Integer.parseInt(scanner.nextLine());
            Kiralama kiralama = Kiralama.builder()
                    .arac(arac)
                    .kisi(kisi)
                    .baslangicTarihi(LocalDate.now())
                    .bitisTarihi(LocalDate.now().plusDays(day))
                    .build();
            kiralamaController.save(kiralama);
            arac.setDurum(true);
            aracController.update(arac);
        }
    }

    





}//CLASS ENDS HERE ----