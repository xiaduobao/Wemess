package com.jnote.thread.foreach.print;

import java.util.concurrent.Semaphore;

public class ForBarSemaphore {

    private int n;

    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public ForBarSemaphore(int n) {
        this.n = n;
    }

    public void printFoo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire(1);
            System.out.println("foo");
            bar.release();
        }
    }


    public void printBar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire(1);
            System.out.println("bar");
            foo.release();
        }
    }

    public static void main(String[] args) {
        ForBarSemaphore forBarBlockingQueen = new ForBarSemaphore(5);
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

    }




}
