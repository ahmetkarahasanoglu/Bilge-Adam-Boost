package com.ahmet.designpattern.solid.dependency;

import java.util.Random;

public class KrediKarti implements IOdemeYontemi{

    Long id;

    public KrediKarti() {
        this.id = new Random().nextLong();
    }

    public Long getId() {
        return this.id;
    }
}
