package com.jnote.thread.foreach.print;

public class FooBarSynchronized {


    private volatile int  flag = 1;

    private int n;

    private Object objLock;

    public FooBarSynchronized(int n, Object objLock) {
        this.n = n;
        this.objLock = objLock;
    }


    public void printFoo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (objLock) {
                while (flag != 1) {
                    objLock.wait();
                }
                System.out.println("foo");
                flag = 2;
                objLock.notifyAll();
            }

        }

    }


    public void printBar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (objLock) {
                while (flag!=2) {
                    objLock.wait();
                }
                System.out.println("bar");
                flag = 3;
                objLock.notifyAll();
            }
        }

    }

    public void printBob() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (objLock) {
                while (flag!=3) {
                    objLock.wait();
                }
                System.out.println("bob");
                flag = 1;
                objLock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        FooBarSynchronized forBarBlockingQueen = new FooBarSynchronized(5, new Object());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    forBarBlockingQueen.printFoo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    forBarBlockingQueen.printBar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    forBarBlockingQueen.printBob();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
