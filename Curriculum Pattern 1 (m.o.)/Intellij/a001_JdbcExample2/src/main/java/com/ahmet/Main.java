package com.ahmet;

import com.ahmet.controller.FutbolcuController;
import com.ahmet.repository.FutbolcuRepository;
import com.ahmet.repository.entity.Futbolcu;
import com.ahmet.service.FutbolcuService;
import com.ahmet.utility.ConnectionProvider;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    FutbolcuController futbolcuController;

    // constructor:
    public Main() {
        this.futbolcuController = new FutbolcuController();
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.menu();

        // --- Test amaçlı kullandık aşağıdaki kodları. Projeyi geliştirirken.
//        ConnectionProvider connectionProvider = new ConnectionProvider();
//        connectionProvider.openConnection();
//        connectionProvider.closeConnection();
//        connectionProvider.openConnection();
//        connectionProvider.closeConnection();

//        FutbolcuRepository futbolcuRepository = new FutbolcuRepository();
//        Futbolcu futbolcu = new Futbolcu("Berk", "Orta Saha", 7, 1L);
//        Futbolcu futbolcu = new Futbolcu("Selim", "Defans", 5, 1000000L, 2L);
//        futbolcu.setId(3L);
//        futbolcuRepository.save(futbolcu);
//        futbolcuRepository.update(futbolcu);

//        Optional<Futbolcu> futbolcu = futbolcuRepository.findById(4L);
//        if(futbolcu.isPresent()) {
//            System.out.println(futbolcu.get());
//        }else {
//            System.out.println("Böyle bir futbolcu bulunamadı.");
//        }

//        List<Futbolcu> futbolcuList = futbolcuRepository.findAll();
//        futbolcuList.forEach(System.out::println);

//        futbolcuRepository.delete(4L);



    }//MAIN ENDS HERE -----

    public void menu() {
        int input = 0;
        do {
            System.out.println("------- MENU -------");
            System.out.println("1- Futbolcu Olustur");
            System.out.println("2- Futbolcu Guncelle");
            System.out.println("3- Futbolcu Sil");
            System.out.println("4- Futbolcu Bul");
            System.out.println("5- Tüm Futbolcuları Getir");
            System.out.println("0- Çıkış");
            System.out.print("Lütfen bir seçim yapınız: ");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    futbolcuOlustur();
                    break;
                case 2:
                    futbolcuGuncelle();
                    break;
                case 3:
                    futbolcuSil();
                    break;
                case 4:
                    futbolcuBul();
                    break;
                case 5:
                    futbolculariListele();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor.");
                    break;
                default:
            }

        }while(input!=0);


    }

    private void futbolcuGuncelle() {
        System.out.print("Lütfen isim giriniz: ");
        String isim = scanner.nextLine();
        System.out.print("Lütfen mevki giriniz: ");
        String mevki = scanner.nextLine();
        System.out.print("Lütfen forma_no giriniz: ");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.print("Lütfen takım id giriniz: ");
        Long takimId = Long.parseLong(scanner.nextLine());
        System.out.print("Lütfen futbolcunun degerini giriniz: ");
        Long deger = Long.parseLong(scanner.nextLine());
        System.out.print("Lütfen güncellemek istediğiniz futbolcunun id'sini giriniz: ");
        Long id = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(isim, mevki, formaNo, deger, takimId);
        futbolcu.setId(id);
        futbolcuController.update(futbolcu);
    }

    private void futbolcuOlustur() {
        System.out.print("Lütfen isim giriniz: ");
        String isim = scanner.nextLine();
        System.out.print("Lütfen mevki giriniz: ");
        String mevki = scanner.nextLine();
        System.out.print("Lütfen forma_no giriniz: ");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.print("Lütfen takım id giriniz: ");
        Long takimId = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(isim, mevki, formaNo, takimId);
        futbolcuController.save(futbolcu);
    }

    private void futbolculariListele() {
        System.out.println("==== Futbolcu Listesi ====");
        futbolcuController.findAll().forEach(System.out::println);
    }

    private void futbolcuBul() {
        System.out.print("Lütfen futbolcu id'si giriniz: ");
        Long id = Long.parseLong(scanner.nextLine());
        Optional<Futbolcu> futbolcu = futbolcuController.findById(id);
        futbolcu.ifPresent(System.out::println);
    }


    private void futbolcuSil() {
        System.out.print("Lütfen futbolcu id'si giriniz: ");
        Long id = Long.parseLong(scanner.nextLine());
        futbolcuController.delete(id);
    }

}//CLASS ENDS HERE ----