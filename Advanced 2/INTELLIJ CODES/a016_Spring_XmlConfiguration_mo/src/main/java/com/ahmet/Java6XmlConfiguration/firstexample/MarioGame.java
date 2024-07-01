package com.ahmet.Java6XmlConfiguration.firstexample;

import lombok.ToString;

@ToString
public class MarioGame implements IGameConsole {


    public void up() {
        System.out.println("Zıpladı.");
    }

    public void down() {
        System.out.println("Deliğe girdi.");
    }

    public void left() {
        System.out.println("Geriye döndü.");
    }

    public void right() {
        System.out.println("Hızlandı.");
    }

}
