package com.ahmet;

public class B {

    private A a;

    public B() {
        a = new A();
    }

    public void print() {
        System.out.println(a.getErrorMessage());
    }

}
