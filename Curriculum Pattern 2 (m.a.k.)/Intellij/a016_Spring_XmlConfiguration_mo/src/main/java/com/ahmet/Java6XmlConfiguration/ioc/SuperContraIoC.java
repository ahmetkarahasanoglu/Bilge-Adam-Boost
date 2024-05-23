package com.ahmet.Java6XmlConfiguration.ioc;

import org.springframework.stereotype.Component;

@Component
public class SuperContraIoC implements IGameConsoleIoc {

    @Override
    public void up() {
        System.out.println("yukarı");
    }

    @Override
    public void down() {
        System.out.println("egil");
    }

    @Override
    public void right() {
        System.out.println("geri git");
    }

    @Override
    public void left() {
        System.out.println("kursun at");
    }
}
