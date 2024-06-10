package com.ahmet;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//        IPrinter printer = new ErrorPrinter();
//        IProvider provider = new MessageProviderEN();
//        printer.setProvider(provider);
//        printer.print();

        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        IPrinter printer = factory.getBean("printer", IPrinter.class); // Nesne oluşturma işini Spring kendisi yapıyormuş.
        printer.print(); // "Hello World" yazıyo.  spring.xml'de Bean'in ismini "MessageProviderTR" yaparsak bu sefer "Merhaba Dünya" yazar.


    }
}