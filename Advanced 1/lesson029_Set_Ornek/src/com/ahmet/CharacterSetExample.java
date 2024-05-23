package com.ahmet;

import java.util.HashSet;
import java.util.Set;

public class CharacterSetExample {
    public static void main(String[] args) {
        // Dışarıdan bir string değeri al
        String input = "araba";

        // Set'leri oluştur
        Set<Character> repeatingSet = new HashSet<>();
        Set<Character> nonRepeatingSet = new HashSet<>();

        // Her harfi kontrol et
        for (char c : input.toCharArray()) {
            // Set içinde var mı kontrol et
            if (!nonRepeatingSet.contains(c) && !repeatingSet.contains(c)) {
                // İlk kez görülen harfi nonRepeatingSet'e ekle
                nonRepeatingSet.add(c);
            } else if (nonRepeatingSet.contains(c)) {
                // Daha önce nonRepeatingSet'te bulunan harfi nonRepeatingSet'ten çıkar, repeatingSet'e ekle
                nonRepeatingSet.remove(c);
                repeatingSet.add(c);
            }
            // Daha önce repeatingSet'te bulunan harfi atla
        }

        // Sonuçları yazdır
        System.out.println("Kelime: " + input);
        System.out.println("Tekrar edenler: " + repeatingSet);
        System.out.println("Tekrar etmeyenler: " + nonRepeatingSet);
    }
}
