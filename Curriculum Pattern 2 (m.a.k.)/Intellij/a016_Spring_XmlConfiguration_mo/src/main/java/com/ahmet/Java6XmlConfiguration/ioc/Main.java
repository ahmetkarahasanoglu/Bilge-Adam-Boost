package com.ahmet.Java6XmlConfiguration.ioc;

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
                new AnnotationConfigApplicationContext(IocConfig.class);

//        String myName = context.getBean("name", String.class);
//        System.out.println(myName);
//        IGameConsoleIoc marioGameIoc = context.getBean(IGameConsoleIoc.class);
//        System.out.println(marioGameIoc.getClass().getSimpleName());

        GameRunnerIoC gameRunnerIoC = context.getBean("gameRunner", GameRunnerIoC.class);
        gameRunnerIoC.run();


    }

}