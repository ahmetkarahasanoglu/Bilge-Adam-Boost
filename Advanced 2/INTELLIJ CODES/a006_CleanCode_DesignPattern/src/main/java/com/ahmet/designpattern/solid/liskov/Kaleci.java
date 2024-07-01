package com.ahmet.designpattern.solid.liskov;

public class Kaleci extends Oyuncu implements IOyuncu {

    @Override
    public void topuElleTut() {
        System.out.println("Kaleci topu elle yakaladı.");
    }
}
