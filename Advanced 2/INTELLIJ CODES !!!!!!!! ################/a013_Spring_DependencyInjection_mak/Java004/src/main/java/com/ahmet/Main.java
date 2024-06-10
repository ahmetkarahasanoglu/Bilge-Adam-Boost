package com.ahmet;

public class Main {
    public static void main(String[] args) {

        IProvider provider;
        IPrinter printer;

        /**
         * tr için
         */
        provider = new MessageProviderTR();
        printer = new ErrorPrinter();
        printer.setProvider(provider);
        printer.print();

        /**
         * de için
         */
        provider = new MessageProviderDE();
        printer.setProvider(provider);
        printer.print();
    }
}