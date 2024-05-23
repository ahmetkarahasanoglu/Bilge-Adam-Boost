package org.randomuser;

import com.google.gson.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) throws Exception {
        System.out.println("***** KULLANICI DATALARI *****");
        System.out.println("İşlem başladı...");
        Scanner sc = null;
        sc = new Scanner(new URL("https://randomuser.me/api/?results=50").openStream(), "UTF-8");
        StringBuilder sb = new StringBuilder();
        String row;
        while(sc.hasNext()) {
            row = sc.nextLine();
            sb.append(row);
        }
        System.out.println("Bütün datalar çekildi.");

        List<Person> kullaniciListesi = new ArrayList<>();
        Gson gson = new Gson();
        /**
         * Elimizde bulunan string halindeki json data'yı jsonElement olarak parse ediyoruz:         *
         */
        JsonElement jsonElement = JsonParser.parseString(sb.toString());
        // '--> jsonElement'ten de json objesine çeviriyoruz:
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        // Json object'e çevrilen data'nın içinden artık istediğimiz key ile gerekli bilgileri çekebiliriz:
        JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();
        int size = jsonArray.size();
        for(int i=0;i<size; i++) {
            JsonObject p = jsonArray.get(i).getAsJsonObject();
            Person person = gson.fromJson(p, Person.class);
            kullaniciListesi.add(person);
        }

//        kullaniciListesi.forEach(System.out::println);

        /**
         * Canada'da oturanları listeleyiniz.
         */
//        kullaniciListesi.stream()
//                .filter(x -> x.location.getCountry().equalsIgnoreCase("Canada")).forEach(System.out::println);

        /**
         * Yaşı 20 ile 45 arasında olan kadınların listesini getir:
         */
//        kullaniciListesi.stream()
//                .filter(x -> x.getGender().equalsIgnoreCase("female") && x.getDob().getAge()>20 && x.getDob().getAge()<45)
//                .forEach(System.out::println);

        /**
         * Norway'de yaşayan insanların yaş ortalaması nedir?
         */
//        Double ortalama = kullaniciListesi.stream()
//                .filter(x -> x.getLocation().getCountry().equalsIgnoreCase("Norway"))
//                .collect(Collectors.averagingDouble(y -> y.getDob().getAge()));
//        System.out.println("Norveç'tekilerin ortalama yaşı: " + ortalama);

        /**
         * Kullanıcı listesini ülkelere göre map haline getiriniz:
         */
        Map<String, List<Person>>  countryPersonList =
                kullaniciListesi.stream()
                        .collect(Collectors.groupingBy(person -> person.getLocation().getCountry(),
                                TreeMap::new,  // Bu ve alttaki satırı yazmasak da çalışıyor, denedim. [groupingBy() fonkisyonunun farklı kullanımı].
                                Collectors.toList()
                        ));
        countryPersonList.forEach((k,v) -> System.out.println(k + " --> " + v));


    }//MAIN ENDS HERE --------

}//CLASS ENDS HERE --------
