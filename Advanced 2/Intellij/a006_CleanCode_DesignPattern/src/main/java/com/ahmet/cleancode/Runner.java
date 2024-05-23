package com.ahmet.cleancode;

public class Runner {

    public static void main(String[] args) {
        /**
         *   --- CLEAN CODE: ---
         * 1- Kodun anlaşılır ve açık bir şekilde yazılması.(code smell)
         * 2- Kodlarınızı (class'ları) soyutlarken oluşturduğunuz sınıfların
         *    tek bir görev yapmasını sağlayın.
         *    - Tek sorumluluk ilkesi (single responsibility)
         * 3- Sınıflarınızın olabildiğince az metot kullanmasını
         *    sağlayınız. İdeali 10-15 metot.
         * 4- Tek bir metot tek bir iş yapmalıdır. Bir metodun yaptığı
         *    iş-kod, başka bir metodun gövdesinde copy-paste yapılmamış
         *    ve kullanılmamış ise muhtemelen doğru bir iş yapıyorsunuzdur.
         *    Metotlarda tekrar eden kodunuz asla olmasın.
         * 5- Metotlarınızı olabildiğince küçük tutun. 15-20 satır
         *    aralığında olması tercihimizdir. İçinde kullanacağınız
         *    değişkenleri max 2-3 değişken olacak şekilde kurgulayın.
         * 6- Metotlarda karar yapıları kullanılmaktadır. Bu karar
         *    yapılarını max 7-8 adet kullanmak doğrudur.
         * 7- Metot yazarken ilk başlarda küçükolabilir. Ancak ilerleyen
         *    zaman içinde gelen istekler neticesinde metot genişlemeye
         *    başlar ve okunurluğu azalır. Böyle durumlarla karşılaşmammak
         *    için kodlarınızı 5'nci maddede olduğu şeklinde muhafaza etmek
         *    için bölmek mantıklıdır.
         * 8- Metotlarımız birbirlerine yakın işlemler yapabilirler. Yakın
         *    işlemler yapılan kod öbeklerini başka bir metotta toplayıp diğer
         *    metotlarınızın bu yeni metodu çağırmasını sağlarsınız.
         * 9- Bir proje içinde metot isimlerinin bir standardı olmalı. Metot
         *    isimlerini proje için nasıl yazmaya karar verdiyseniz tüm proje
         *    boyunca öyle yazınız.
         * 10- Metot ismi tanımlarken, olabildiğince ingilizce kullanın.
         *     İsimlendirme yaparken, yaptıkları işi niteleyen bir kelime kullanın
         *     ve olabildiğince emir kipi kullanarak tanımlayın.
         * 11- Metot isimlendirmesi yaparken asla kısaltma kullanmayın. Uzun
         *     uzuuuuuuun yazın.
         *     Örn: satisSonrasiMusteriIdsiUzerindenAlinanUcretKayitlarininToplamTutari(long musteriId);
         * 12- Mutlaka metotlarınızn üzerinde yorum satırlarını ekleyin. Uygulamayı
         *     kendiniz kullanacak, tek başınıza yazacak olsanınz bile açıklama yazmadan
         *     metot yazmayın.
         * 13- Metotlarınıza isim verirken zorlanıyorsanız, muhtemelen kodu yanlış
         *     yazmışsınızdır ve metot birden çok iş yapıyordur.
         * 14- Bir proje içinde projeye başlamadan; ClassName, MethodName ve
         *     DataTypeName atamaları belirlenmeli ve bu şekilde proje bitene kadar
         *     aynen kalmalıdır.
         *     ClassName    -> MusteriRepository
         *     MethodName   -> findAllByName
         *     DataTypeName -> lastmount, createat, v.s. final IPADDRESS
         *
         */


    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE -----
