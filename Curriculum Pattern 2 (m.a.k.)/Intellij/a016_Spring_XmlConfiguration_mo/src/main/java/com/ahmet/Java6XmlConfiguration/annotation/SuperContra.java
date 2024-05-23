package com.ahmet.Java6XmlConfiguration.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // We're giving this class priority among other components; otherwise it gives error in the output stating that there are multiple 'Component' classes available.
public class SuperContra implements IGameConsole {

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
