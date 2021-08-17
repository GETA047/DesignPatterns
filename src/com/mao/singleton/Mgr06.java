package com.mao.singleton;

/**
 * 懒汉式
 * 虽然达到按需初始化的目的，但是带来线程不安全的问题
 * 通过synchronized解决问题，但带来效率下降
 */
public class Mgr06 {

    private static Mgr06 INSTANCE;

    private Mgr06() {

    }

    public static Mgr06 getInstance() {
        //双重检查
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }

}
