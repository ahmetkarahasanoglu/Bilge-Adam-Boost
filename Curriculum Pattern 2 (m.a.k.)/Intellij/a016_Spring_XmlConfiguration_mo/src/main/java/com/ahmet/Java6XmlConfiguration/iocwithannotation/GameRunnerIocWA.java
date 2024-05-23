package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 'Spring tarafından yönetilen sınıf'.  (örn: Repository, Service, Controller -> bunlar Component'in alt kırılımlarıdır)
public class GameRunnerIocWA {

    @Autowired // otomatik nesne oluştursun IGameConsoleIocWA'dan.
    @Qualifier("mario") // IGameConsoleIocWA'yı 'mario'dan oluşturmasını belirtiyoruz.
    IGameConsoleIocWA game;

//    public GameRunnerIocWA(IGameConsoleIocWA gameSelected) {
//        this.game = gameSelected;
//    }

    public void run() {
        System.out.println("Oyun çalışıyor: " + game.getClass().getSimpleName());
        System.out.println("Hash code: " + game.hashCode());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
