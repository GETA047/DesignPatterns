package com.mao.singleton;

/**
 * 懒汉式 lazy loading
 * 虽然达到按需初始化的目的，但是带来线程不安全的问题
 */
public class Mgr03 {
    private static Mgr03 INCETANCE;

    private Mgr03() {

    }

    public static Mgr03 getIncetance() {
        if (INCETANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INCETANCE = new Mgr03();
        }
        return INCETANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr03.getIncetance().hashCode())).start();
        }
    }
}
