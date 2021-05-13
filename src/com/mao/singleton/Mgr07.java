package com.mao.singleton;

/**
 * 静态内部类方式
 */
public class Mgr07 {
    private Mgr07(){}

    private static class HolderMgr07{
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return HolderMgr07.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
