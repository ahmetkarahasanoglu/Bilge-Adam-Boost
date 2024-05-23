package pckge;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DogumGunuChatGpt {
    public static void main(String[] args) {
        // Kullanıcıdan doğum tarihini al
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doğum tarihinizi yyyy-MM-dd formatında girin: ");
        String dogumTarihiStr = scanner.nextLine();
        scanner.close();

        // Şuanki tarihi al
        LocalDate bugun = LocalDate.now();

        // Doğum tarihini LocalDate formatına dönüştür
        LocalDate dogumTarihi = LocalDate.parse(dogumTarihiStr);

        // Yaş hesaplaması
        long yasYil = ChronoUnit.YEARS.between(dogumTarihi, bugun);
        long yasGun = ChronoUnit.DAYS.between(dogumTarihi, bugun);
        long yasHafta = ChronoUnit.WEEKS.between(dogumTarihi, bugun);
        long yasAy = ChronoUnit.MONTHS.between(dogumTarihi, bugun);

        // Bir sonraki doğum gününe kalan gün hesaplama
        LocalDate birSonrakiDogumGunu = dogumTarihi.plusYears(yasYil + 1);
        long gunKaldi = ChronoUnit.DAYS.between(bugun, birSonrakiDogumGunu);

        // Sonuçları yazdır
        System.out.println("Şu ana kadar yaşadığınız süre:");
        System.out.println("Yıl: " + yasYil);
        System.out.println("Ay: " + yasAy);
        System.out.println("Hafta: " + yasHafta);
        System.out.println("Gün: " + yasGun);

        System.out.println("Bir sonraki doğum gününüze kalan gün sayısı: " + gunKaldi);
    }
}
