package com.ahmet.Java6XmlConfiguration.ioc;

import org.springframework.stereotype.Component;

@Component
public class PacmanIoC implements IGameConsoleIoc {

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
