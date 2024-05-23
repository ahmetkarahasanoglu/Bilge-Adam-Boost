package com.bilgeadam;

import com.bilgeadam.controller.ClubController;
import com.bilgeadam.controller.LeaugeController;
import com.bilgeadam.controller.PlayerController;
import com.bilgeadam.repository.PlayerRepository;
import com.bilgeadam.repository.entity.Club;
import com.bilgeadam.repository.entity.Player;
import com.bilgeadam.repository.entity.PlayerPositions;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    PlayerController playerController = new PlayerController();
    ClubController clubController = new ClubController();
    LeaugeController leaugeController = new LeaugeController();
    Club myClub;

    public static void main(String[] args) {
        App app = new App();
        app.mainMenu();

    }


    public void mainMenu() {

        int input = 0;

        do {
            System.out.println("=========Football APP===========");
            System.out.println("1-Takım seç");
            System.out.println("2-Takımları görüntüle");
            System.out.println("3-Ligleri gorüntüle");
            System.out.println("4-Takım-Yonetim-Menusu");
            System.out.println("5-Pozisyona göre oyuncuları getir");
            System.out.println("6-Orta Saha oyuncuları getir");//CM, CDM, CAM, RM, LM
            System.out.println("7-Bölgelere göre oyuncuları getir");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    System.out.println(selectClub());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    menageClub();
                    break;
                case 5:
                    System.out.println("Lütfen Bir pozisyon ismi giriniz");
                    playerController.findAllByPositionName(scanner.nextLine()).forEach(System.out::println);
                    break;
                case 6:
                    new PlayerRepository().findByMid().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Lütfen Bir pozisyon ismi giriniz");
                    playerController.findByArea(scanner.nextLine()).forEach(System.out::println);
                    break;
            }


        } while (input != 0);

    }

    private void menageClub() {
        if (myClub != null) {
            clubMenu();
        } else {
            System.out.println("Lütfen bir takım Seciniz Ana Menuye geri donuluyor!!!!");
        }
    }

    private void clubMenu() {
        int choose = 0;
        do {
            System.out.println("Takımınız: " + myClub.getClub_name());
            System.out.println("1-Oyuncuları Goruntule");
            System.out.println("2-");
            System.out.println("0-Ana Menuye Dön");
            System.out.println("Lütfen bir secim yapınız");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    myClubPlayerList(myClub);
                    break;
                case 2:
                    break;

            }

        } while (choose != 0);
    }

    public void myClubPlayerList(Club club) {
        club.getPlayers().forEach(System.out::println);
    }

    private Club selectClub() {
        clubController.findAll().forEach(s -> System.out.println(s.getId() + "-" + s.getClub_name()));
        System.out.println("Lütfen klüp-idsi giriniz");
        Long id = Long.parseLong(scanner.nextLine());
        Optional<Club> club = clubController.findById(id);
        if (club.isPresent()) {
            myClub = club.get();
        } else {
            myClub = null;
        }
        return myClub;
    }



}
