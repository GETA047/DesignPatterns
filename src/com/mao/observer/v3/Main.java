package com.mao.observer.v3;

/**
 * 加入观察者
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();

    }
}

class Child {
    private boolean cry = false;
    private Dad dad = new Dad();

    public Boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
    }
}

class Dad {

    public void feed() {
        System.out.println("dad feeding...");
    }
}

