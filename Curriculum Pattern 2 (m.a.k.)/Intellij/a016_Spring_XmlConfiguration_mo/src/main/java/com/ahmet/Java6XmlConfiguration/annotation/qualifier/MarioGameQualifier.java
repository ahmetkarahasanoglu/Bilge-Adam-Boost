package com.ahmet.Java6XmlConfiguration.annotation.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@ToString
@Component
@Qualifier("mario")
public class MarioGameQualifier implements IGameConsole {


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
