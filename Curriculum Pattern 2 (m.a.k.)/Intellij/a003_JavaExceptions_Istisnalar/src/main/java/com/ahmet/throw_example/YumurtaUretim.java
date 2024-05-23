package com.ahmet.throw_example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class YumurtaUretim {
    private static int kumesSayisi = 23;
    private Map<Integer, Integer> yumurtaSayisi; // (key: kumesNo, value: kümesteki yumurta sayısı)
    private int gunlukYumurtaUretim;
    private int tavukSayisi = 3460;

    /**
     * Burada constructor private yaparak bu sınıftan bir
     * nesne üretilmesinin önüne geçiyorum.
     */
    private YumurtaUretim() {

    }

    /**
     * Bu Init() metodunda dışardan parametre almadan,
     * lazım olan şeyleri üretiyoruz. Direkt class üzerinden
     * erişilebilecek (statik yaptık).
     *
     * @return
     */
    public static YumurtaUretim Init() { // This approach enables to use only a single instance of a class (the static init method).
        YumurtaUretim yumurtaUretim = new YumurtaUretim();
        yumurtaUretim.yumurtaSayisi = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < kumesSayisi; i++) {
            int yumurtaAdedi = random.nextInt(100);
            yumurtaUretim.yumurtaSayisi.put(i, yumurtaAdedi);
        }
        return yumurtaUretim;
    }

    /**
     * DİKKAT !!!!
     * Checked & Unchecked Exception.
     * Unchecked Exception -> Bir metot hata fırlatabilir ancak bunu kontrol etmek zorunda değiliz, isteğe bağlıdır.
     *
     * @param kumesNumarasi
     * @return
     */
    public int yumurtaSay(int kumesNumarasi) {
        if (kumesNumarasi < 0 || kumesNumarasi >= kumesSayisi) {
            /**
             * - YANLIS KULLANIM:
             * System.out.println("Lütfen 0 ile " + kumesSayisi + " arasında bir değer giriniz.");
             * return 0;
             * - DOGRU OLAN:
             * Özelleştirilmiş istisna fırlatmaktır:
             * 1. adım -> throw new
             * 2. adım -> istisnanın türünü yazıyorsunuz
             * 3. adım -> vermek istediğiniz mesajı yazıyorsunuz.
             */
            throw new ArithmeticException("Girmiş olduğunuz kümes bilgisi yanlıştır. Lütfen 0 ile " + kumesSayisi + " arasında bir değer giriniz."); // 'throw' anahtar kelimesiyle istediğim tipte hata fırlatabiliyorum, ve açıklama metni girebiliyorum parametre olarak.
//          // '--> hata throw ettiğimiz zaman return yazmak zorunda değiliz.
//            return yumurtaSayisi.get(kumesNumarasi);
        } else {
            return yumurtaSayisi.get(kumesNumarasi);
        }
    }

    /**
     * Checked Exception:
     * Tanımlandığı yerde 'throws ....' yazılmalıdır. Bu metodu
     * kullanacak yazılımcıların mutlaka bu metodu sarmalamaları
     * veya istisna fırlatmaları gereken durumlardır(Runner
     * sınıfında yapcaz).
     *
     * @param kumesNumarasi
     * @return
     * @throws Exception
     */
    public int yumurtaSay_Checked(int kumesNumarasi) throws Exception {
        if (kumesNumarasi < 0 || kumesNumarasi >= kumesSayisi) {
            /**
             * - YANLIS KULLANIM:
             * System.out.println("Lütfen 0 ile " + kumesSayisi + " arasında bir değer giriniz.");
             * return 0;
             * - DOGRU OLAN:
             * Özelleştirilmiş istisna fırlatmaktır:
             * 1. adım -> throw new
             * 2. adım -> istisnanın türünü yazıyorsunuz
             * 3. adım -> vermek istediğiniz mesajı yazıyorsunuz.
             */
            throw new Exception("Girmiş olduğunuz kümes bilgisi yanlıştır. Lütfen 0 ile " + kumesSayisi + " arasında bir değer giriniz."); // 'throw' anahtar kelimesiyle istediğim tipte hata fırlatabiliyorum, ve açıklama metni girebiliyorum parametre olarak.
        } else {
            return yumurtaSayisi.get(kumesNumarasi);
        }


    }
}
