package com.jnote.thread.foreach.print;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ForBarBlockingQueen {

    private int n;

    private BlockingQueue foo = new LinkedBlockingDeque(1);
    private BlockingQueue bar = new LinkedBlockingDeque(1);

    public ForBarBlockingQueen(int n) {
        this.n = n;
    }

    public void printFoo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.put(1);
            System.out.println("foo");
            bar.put(1);

        }
    }


    public void printBar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.poll();
            System.out.println("bar");
            bar.poll();
        }
    }

    public static void main(String[] args) {
        ForBarBlockingQueen forBarBlockingQueen = new ForBarBlockingQueen(5);
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
