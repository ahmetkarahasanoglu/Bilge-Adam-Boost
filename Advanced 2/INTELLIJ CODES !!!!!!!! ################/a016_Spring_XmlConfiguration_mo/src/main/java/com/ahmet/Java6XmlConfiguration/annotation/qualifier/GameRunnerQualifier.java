package com.ahmet.Java6XmlConfiguration.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunnerQualifier {

    @Autowired // --> bizim için new'leme işlemini yapar.
    @Qualifier("mario") // nerden new'leneceği
    IGameConsole game;

//    public GameRunnerQualifier(@Qualifier("pacman") IGameConsole gameSelected) {
//        this.game = gameSelected;
//    }

    public void run() {
//        System.out.println("Oyun çalışıyor: " + marioGame.getClass().getName());
//        marioGame.up();
//        marioGame.down();
//        marioGame.left();
//        marioGame.right();
//        System.out.println("Oyun çalışıyor: " + pacman.getClass().getName());
//        pacman.up();
//        pacman.down();
//        pacman.left();
//        pacman.right();
        System.out.println("Oyun çalışıyor: " + game.getClass().getSimpleName());
        System.out.println("Hash code: " + game.hashCode());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
