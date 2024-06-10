package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contra")
public class SuperContraIoCWA implements IGameConsoleIocWA {

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
