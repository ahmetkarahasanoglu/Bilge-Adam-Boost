package com.ahmet.designpattern.solid.liskov;

public class Runner {

    public static void main(String[] args) {
        Forvet f = new Forvet();
        Kaleci k = new Kaleci();
        f.topaVur("Forvet");
        k.topaVur("Kaleci");
        k.topuElleTut();

    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----

