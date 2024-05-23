package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@ToString
@Component // 'Spring tarafından yönetilen sınıf'.  (Repository, Service, Controller -> bunlar Component'in alt kırılımlarıdır)
@Qualifier("mario")
public class MarioGameIoCWA implements IGameConsoleIocWA {


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
