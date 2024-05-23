package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IocConfigWA.class);


        GameRunnerIocWA gameRunnerIoC = context.getBean(GameRunnerIocWA.class);
        gameRunnerIoC.run();


    }

}