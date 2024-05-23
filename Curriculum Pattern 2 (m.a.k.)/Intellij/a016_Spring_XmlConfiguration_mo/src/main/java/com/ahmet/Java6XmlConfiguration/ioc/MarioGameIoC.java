package com.ahmet.Java6XmlConfiguration.ioc;

import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component // 'Spring tarafından yönetilen sınıf'.  (Repository, Service, Controller -> bunlar Component'in alt kırılımlarıdır)
public class MarioGameIoC implements IGameConsoleIoc {


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
