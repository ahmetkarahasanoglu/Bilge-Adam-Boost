package com.ahmet.Java6XmlConfiguration.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 'Spring tarafından yönetilen sınıf'.  (örn: Repository, Service, Controller -> bunlar Component'in alt kırılımlarıdır)
public class GameRunnerIoC {

    IGameConsoleIoc game; // Polimorfizm ile kod sayısını azaltıyoruz.

    public GameRunnerIoC(IGameConsoleIoc gameSelected) {
        this.game = gameSelected;
    }

    public void run() {
        System.out.println("Oyun çalışıyor: " + game.getClass().getSimpleName());
        System.out.println("Hash code: " + game.hashCode());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
