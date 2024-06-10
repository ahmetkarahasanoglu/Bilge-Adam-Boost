package com.ahmet;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        /*
         *    Kullanıcılardan almış olduğumuz datalar, bir şekilde kayıt
         * altına alınmalı ve gerekli olduğu zaman tekrar çağrılarak
         * kullanılmalıdır.
         *    Dataların kalıcı olarak kayıt edildiği uygulamalara DataBase
         * adı verilir. Bu uygulamalar ile datalar uzun süreli saklanır
         * ve yedeklenirler.
         *    Dataların ihtiyaca göre işlenmeye ihtiyacı vardır. Bu
         * nedenle gerekli olduğunda farklı sorgularla çağrılmalıdırlar.
         * Örneğin:
         *    - bir kişiye ait sepet bilgisini görmek isiyoruz.
         *    - bir kullanıcıının son 3 ayda yaptığı alışverişlerin
         * toplam tutarının tüm müşteriler içindeki oranını görmek
         * istiyoruz.
         *   Bu işlemlerin Database üzerinden yapılması, çok fazla istek
         * atmaya ve sistemi yavaşlatmaya neden olabilir.
         *   ** Veritabanından gerekli olan bilgiler tek seferde alınarak,
         * Listelerin içerisine konulur.
         * Dikkat: Ben daha çok listeler ile çalışmalıyım ki daha
         * performanslı kodlar yazabileyim. Ancak burada dikkat edilmesi
         * gereken durum, listeleri mükemmel bir şekilde kullanabiliyor
         * olmam gerekli.
         *     Stream Api, bizim ihtiyacımız olan listelerin aranması,
         * yönetilmesi için gerekli özelleştirilmiş bir sınıftır. *
         */
        // count = 0;
        Stream<String> bosStream = Stream.empty();
        // count = 1;
        Stream<String> tekilStream = Stream.of("Pazartesi");
        // count = 4;
        Stream<Double> sayilar = Stream.of(22d, 1d, 11d, 2.5d);
        List<String> gunler = List.of("pzt.", "sa.", "çar.", "per.", "cu.", "ctes.", "paz.");

        /*
         * Tüm listelerde stream miras olarak alınmaktadır. Bu
         * nedenle tüm listeler stream'e döndürülebilir.
         * örn: gunler.stream()
         */

        /*
         * List -> Stream 'e çevirelim ve içindeki parametreleri
         * dönelim:
         */
        Stream<String> gunlerStream = gunler.stream();  // List'i Stream'e çevirdik.
//		gunlerStream.forEach(System.out::println);
//		gunlerStream.forEach(g->System.out.println(g)); // Tek satır kod çalıştırabiliyoruz burda.
        gunlerStream.forEach(g->{
            System.out.println("Önce yapılacaklar");
            System.out.println(g);
            System.out.println("ek işlemleri");
        });

        // --- SONSUZ STREAM'LER: ---
        Stream<Double> rastgeleRandomSayilar = Stream.generate(Math::random);
//		rastgeleRandomSayilar.forEach(System.out::println);

        Stream<Integer> fonksiyonSayilar = Stream.iterate(1, n -> n+2); // 1 3 5 7 ... infinitely
//		fonksiyonSayilar.forEach(System.out::println);

        fonksiyonSayilar = Stream.iterate(1, n -> n<20, n -> n+2);
        fonksiyonSayilar.forEach(p -> System.out.println(p));

        /*
         * --- METOTLAR (stream'in metotları) ---
         * count -> eleman sayısı
         * min, max -> en küçün ve büyük değer
         * forEach -> bileşenlerini dönmek için.
         */


        System.out.println("sayilar count.....: " + sayilar.count());
//		System.out.println("Rastgele sonsuz sayı count...: " + rastgeleRandomSayilar.count());  // çıktıda bir şey göstermez. Sürekli hesaplama yapar, sonsuz döngü.

        Stream<String> isimler = Stream.of("Ahmet", "Can", "Kemalettin", "Buse");
        // Farklar........................:		   2	  7				6
        //bir string ifade dizisinde isim uzunluğu en küçük olanı versin:
        Optional<String> minIsim = isimler.min((s1,s2) -> s1.length() - s2.length());
        minIsim.ifPresent(System.out::println); // Output: Can  ( 'ifPresent' -> Eğer bir minimum değer mevcut ise demektir.)

        /*
         *
         */
        String[] harfler = new String[] {"M", "u", "h", "a", "m", "m", "e", "t"};
        //harflari birleştirip bir kelime yapmak istiyoruz. for( : ) ile yapmamız mümkün:
        String isim = "";
        for(String harf: harfler) {
            isim += harf;
        }
        System.out.println("İsim.........: " + isim);

        Stream<String> streamHarfler = Stream.of("M", "u", "h", "a", "m", "m", "e", "t");
        String streamIsim = streamHarfler.reduce("", (ad,harf)->ad+harf);
        System.out.println("Reduce ile...: " + streamIsim);

        Stream<Integer> streamSayilar = Stream.of(3,5,7);
        Optional<Integer> toplam = streamSayilar.reduce((total, accumulator)-> total + accumulator);
        System.out.println("Toplam (reduce ile): " + toplam.get());

        Stream<Integer> streamInt = Stream.of(3,5,6);
        Integer sonuc = streamInt.reduce(1,(total, accumulator) -> total * accumulator); // Here, '1' is the beginning value of 'total'.
        System.out.println("Çarpım (reduce ile): " + sonuc);

        // BINARY OPERATOR
        BinaryOperator<Integer> op = (a,b) -> a*b;
        Stream<Integer> streamInt2 = Stream.of(3,5,8,2);
        streamInt2.reduce(op).ifPresent(System.out::println);
        Stream<Integer> bosDizi = Stream.empty();
        bosDizi.reduce(op).ifPresentOrElse(p->{
            System.out.println("sonuç: " + p);
        }, () ->{
            System.out.println("Herhangi bir sonuç üretilmedi");
        });
        /*-------------------------------------------------*/       System.out.println("-----------------------------------------------");

        /**
         * COLLECT:
         * Bir koleksiyonun başka bir koleksiyona dönüştürülmesi işlemini yapar.
         */
        Stream<String> isimDizi = Stream.of("b", "a", "h", "a", "r");
        TreeSet<String> setIsim = isimDizi
                .collect(
                        TreeSet::new,
                        TreeSet::add,
                        TreeSet::addAll
                );
        System.out.println("Set isimler.....: " + setIsim);

        // Yukarıdakini yapmanın bir başka yolu:
        Stream<String> isimDizi2 = Stream.of("b", "a", "h", "a", "r");
        TreeSet<String> setIsim2 = isimDizi2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Set isimler(2)..: " + setIsim2);

        /**
         * FILTER:
         * Liste içinde belli kriterlere göre filtreleme yapar.
         * Stream'de en önemli kullanımlardan biridir.
         */
        Stream<String> urunlistesi = Stream.of("Utu", "Duy", "Bilgisayar", "Telefon", "Televizyon", "Buzdolabı", "Bulaşık Makinesi");
        // ismi 't' ile başlayan ürünleri getir:
//        urunlistesi.filter(u->u.startsWith("T")).forEach(System.out::println);
        urunlistesi.filter(u->u.length()>10 || u.length()<4).forEach(System.out::println);

        /**
         * DISTINCT: ('Set' kullanımına benziyo)
         * Bir liste içerisinde tekrar eden kayıtların gösterilmesi
         * istenmiyor ise 'distinct' kullanılır.
         * NOT: String, Integer gibi tekli veri tutan tipleri
         * kullanmak anlamlı iken, Sınıf tipinde ve içinde bir çok
         * alanı barındıran nesneleri kullandığımızda işler
         * karışıyor gibi görünebilir, burada iki nesnenin
         * birebir aynı olması (dolayısıyla adreslerinin de aynı
         * olması gerektiğini unutmayınız)
         *  user1 -> {id:1, name: "Mehmet", surname: "Yılmaz"}
         *  user2 -> {id:1, name: "Mehmet", surname: "Yılmaz"}
         *  user3 -> {id:2, name: "Mehmet", surname: "Yılmaz"}
         *
         *  user1 ve user2'yi -> tekil hale getirir.
         *  user1 ve user3'ü -> tekil hale getirmez, tüm alanları aynı değil.
         */
        Stream<String> musteriListesi = Stream.of("Ali", "Deniz", "Bahar","Gümüş", "Ali", "Deniz", "Bekir"); // 'Ali' ve 'Deniz' 2'şer defa var.
        musteriListesi.distinct().forEach(System.out::println);

        /**
         * LIMIT:
         *  Sonsuz dögülerde işlemin kısıtlı kalmasını sağlamak için
         * kullanılır. Döngü sayısını belirtir.
         *  skip(n): fonksiyonun ilk n interasyonunu atlamasını
         * sağlar.
         */
        Stream<Integer> sayilarI = Stream.iterate(5, s -> s*2);
        sayilarI.skip(3).limit(10).forEach(System.out::println);

        Stream<String> sehirler = Stream.of("Ankara", "İstanbul", "İzmit", "Bursa", "Denizli");
        sehirler.map(String::length).forEach(System.out::println);
        // another way of the above line, is below line:
//        sehirler.map(s -> s.length()).forEach(x -> System.out.println(x));
        System.out.println("-------------");
        List<Urun> AurunSatisListesi = Arrays.asList(new Urun(), new Urun(), new Urun());
        List<Urun> BurunSatisListesi = Arrays.asList(new Urun());
        List<Urun> CurunSatisListesi = Arrays.asList(new Urun(), new Urun(), new Urun(), new Urun());

        Stream<List<Urun>> urunListesi = Stream.of(AurunSatisListesi, BurunSatisListesi, CurunSatisListesi);
        urunListesi.map(List::size).forEach(System.out::println); // Just like Javascript's map(....) method.

        /**
         * SORTING
         * Bir liste içinde belli özelliklere göre sıralama
         * sorted() -> a...Z, 0...9
         * sorted(Comparator.reverseOrder()) -> sorts in reverse order
         */
        Stream<String> isimListesi = Stream.of("Canan", "Zeynep", "Gümüş", "Eren", "Ayşe", "Tekin");
        Stream<String> isimListesi2 = Stream.of("Canan", "Zeynep", "Gümüş", "Eren", "Ayşe", "Tekin");
        isimListesi.sorted().forEach(System.out::println);
        System.out.println("--");
        isimListesi2.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        /**
         * Stream -> Collecting Results:
         * Converting lists to collections
         */
        System.out.println("****** Collecting Results *******");
        System.out.println();
        // var -> bir değişken tanımlama yöntemi, ona ne atarsak o tipe dönüşür.
        var gunListesi = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        var gunListesi2 = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        var gunListesi3 = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        // converting a stream to a whole string:
        String sGunler = gunListesi.collect(Collectors.joining("-"));
        System.out.println(sGunler);
        // Ortalama alma -> Collectors.averagingDouble:
        Double dGunlerAvg = gunListesi2.collect(Collectors.averagingDouble(String::length));
        System.out.println("Günlerin ortalama uzunluğu....: " + dGunlerAvg);
        // Converting a stream to a collection:
        TreeSet<String> tsGunler = gunListesi3
                .filter(g -> g.startsWith("T"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("T ile başlayan günler....: " + tsGunler);

        TreeSet<String> seasons = new TreeSet<String>(Arrays.asList("Spring", "Summer", "Autumn", "Winter"));
        var sIleBaslayanlar = seasons.stream()
                .filter(x ->x.startsWith("S"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sIleBaslayanlar);

        // Örn:  Map<String, Integer>:  Monday->6, Thursday->8....
        gunListesi = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        Map<String, Integer> mapGunler =
                gunListesi.collect(Collectors.toMap(g-> g, String::length));
        System.out.println(mapGunler);

        /**
         * Örn:     Key-> Value
         *      length -> the day itself (multiple days)
         * 4 -> ["Sali", "Cuma"]
         * 5 -> ["Pazar"]
         * 8 -> ["Carsamba", "Persembe"]
         */
        gunListesi = Stream.of("Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar");
        Map<Integer, List<String>> mapListGunler =
                gunListesi.collect(Collectors.groupingBy(String::length));
        System.out.println(mapListGunler);

        // My First Trial(chatGPT) - Örn:  Map<MevsimAdı, Uzunluğu>: Spring->6  (converting list to collection[Map]).
        List<String> seasons2 = new ArrayList<>(Arrays.asList("Spring", "Summer", "Autumn", "Winter"));
        Map<String, Integer> mapSeasons = seasons2
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(), // setting key
                        String::length,      // setting value
                        (existing, replacement) -> existing, // (in case of duplicate keys, choose which value to keep)
                        LinkedHashMap::new
                ));
        System.out.println(mapSeasons);

        var urunList = Stream.of(new Urun("A Marka", "Seker"),
                                 new Urun("A Marka", "Un"),
                                 new Urun("B Marka", "Yağ"),
                                 new Urun("C Marka", "Çikolata"));
        // Hangi markadan hangi ürünler var: (markaya göre gruplama. key=marka)
        Map<String, List<Urun>> markaGrupListesi =
                urunList.collect(Collectors.groupingBy(Urun::getMarka));
        markaGrupListesi.forEach((k,v) -> System.out.println(k + " --> " + v.toString()));


        gunListesi = Stream.of("Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar");
        TreeMap<Integer, List<String>> gList =
                gunListesi.collect(
                        Collectors.groupingBy(
                                String::length,  // or, to group by the first letters:  g -> g.substring(0,1)  [for that, change the 'Integer' to 'String' in the Map (3 lines above)]
                                TreeMap::new,  // TreeMap sorts by the keys of the map.
                                Collectors.toList()
                        )
                );
        System.out.println("Günlerin uzunlukarı....: " + gList);

    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE ------
