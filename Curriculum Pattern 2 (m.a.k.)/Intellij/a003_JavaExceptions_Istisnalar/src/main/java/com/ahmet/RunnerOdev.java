package com.ahmet;

public class RunnerOdev {

    public static void main(String[] args) {
        /**
         * - ClassCastException
         * - IndexOutOfBoundsException
         * - NullPointerException
         * ile ilgili örnekleri içeren ayrı ayrı try-catch
         * blokları yazınız.
         */

        /**
         * HANDLING CLASS CAST EXCEPTION: Birbirlerini kapsayan
         * (biri diğerinden miras almış) sınıfların dönüştürülmesinde
         * karşılaşılan hatadır.
         */
        try {
            Object obj = "Hello"; // Assigning a String object to an Object reference
            Integer num = (Integer) obj; // Trying to cast Object to Integer (which is incompatible)
            System.out.println("Casting successful: " + num);
        } catch (ClassCastException e) {
            System.out.println("Hata: Object integer'a çevrilemez! " + e);
        }

        /**
         * INDEX OUT OF BOUNDS EXCEPTION
         * [3,5,7,9,11] -> size = 5
         * Hata mesajında index:-1 deniyorsa dizi boş demektir.
         * max index -> size-1
         * NullPointerException.
         * Var olmayan bir değerin içeriğine ulaşmaya çalıştığınızda
         * olur.
         */

    }//MAIN ENDS HERE ------

}//CLASS ENDS HERE ----
