package com.jnote.thread.foreach.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarReenTrantLock {


    private volatile int flag = 1;

    private int n;

    private ReentrantLock left = new ReentrantLock();

    private ReentrantLock right = new ReentrantLock();

    private Condition condition = left.newCondition();

    public FooBarReenTrantLock(int n) {
        this.n = n;
    }


    public void printFoo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                left.lock();
                while (flag != 1) {
                    condition.await();
                }
                System.out.println("foo");
                flag = 2;
                condition.signalAll();
            } finally {
                left.unlock();
            }


        }


    }


    public void printBar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                left.lock();
                while (flag != 2) {
                    condition.await();
                }
                System.out.println("bar");
                flag = 3;
                condition.signalAll();
            } finally {
                left.unlock();
            }

        }

    }

    public void printBob() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                left.lock();
                while (flag != 3) {
                    condition.await();
                }
                System.out.println("foo");
                flag = 1;
                condition.signalAll();
            } finally {
                left.unlock();
            }

        }

    }

    public static void main(String[] args) {
        FooBarReenTrantLock forBarBlockingQueen = new FooBarReenTrantLock(5);
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
