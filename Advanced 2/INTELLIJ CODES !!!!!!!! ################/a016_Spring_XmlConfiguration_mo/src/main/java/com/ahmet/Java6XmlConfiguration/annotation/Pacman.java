package com.ahmet.Java6XmlConfiguration.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Pacman implements IGameConsole {

    public void up() {
        System.out.println("Yukarı gitti.");
    }

    public void down() {
        System.out.println("Aşağı gitti.");
    }

    public void left() {
        System.out.println("Sola gitti.");
    }

    public void right() {
        System.out.println("Sağa gitti.");
    }

}
