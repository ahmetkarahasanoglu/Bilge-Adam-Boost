package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pacman")
public class PacmanIoCWA implements IGameConsoleIocWA {

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
