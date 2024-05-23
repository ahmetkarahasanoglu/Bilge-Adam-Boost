package com.ahmet.Java6XmlConfiguration.firstexample;

/**
 * 1- MarioGame sınıfında 4 tane metodumuz olsun:
 *    up() --> zıplama
 *    down() --> çömelme
 *    left() --> sola gitme
 *    right() --> sağa gitme
 *
 *    GameRunner sınıfında bir run metodumuz olsun. Bu metot
 *    MarioGame sınfındaki 4 metodumuz çalıştırsın.
 */
public class Main {

    public static void main(String[] args) {

//        GameRunner gameRunner = new GameRunner(new Pacman());
//        gameRunner.run();

//        GameRunner gameRunner = new GameRunner(new MarioGame());
//        gameRunner.run();

        GameRunner gameRunner = new GameRunner(new SuperContra());
        gameRunner.run();

    }

}
