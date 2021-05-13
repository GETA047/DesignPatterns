package com.mao.observer.v2;

/**
 * 面向对象的傻等
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observer......");
        }
    }
}

class Child {
    private boolean cry = false;

    public Boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Wake up!");
        cry = true;
    }
}