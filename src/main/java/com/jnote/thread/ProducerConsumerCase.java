package com.jnote.thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerCase {

    public static void main(String[] args) throws InterruptedException {
        Object lockObj = new Object();
        List house = new ArrayList();
        Consumer consumer1 = new Consumer(house, lockObj);
        Consumer consumer2 = new Consumer(house, lockObj);
        Consumer consumer3 = new Consumer(house, lockObj);
        Producer producer1 = new Producer(house, lockObj);
        Producer producer2 = new Producer(house, lockObj);
        Producer producer3 = new Producer(house, lockObj);


        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        Thread.sleep(100);

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();

        Thread.sleep(1000000000);
    }
}


class Consumer implements Runnable {
    private List storehouse;

    private Object lockObj;

    public Consumer(List storehouse, Object lockObj) {
        this.storehouse = storehouse;
        this.lockObj = lockObj;
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
        synchronized (lockObj) {
            while (storehouse.size() <= 0) {
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storehouse.remove(0);
            System.out.println(Thread.currentThread() + ": consume item");
            lockObj.notifyAll();
        }
    }
}


class Producer implements Runnable {

    private List storehouse;

    private Object lockObj;

    public Producer(List storehouse, Object lockObj) {
        this.storehouse = storehouse;
        this.lockObj = lockObj;
    }

    @Override
    public void run() {
        produce();
    }

    private void produce() {
        synchronized (lockObj) {
            while (storehouse.size() > 0) {
                lockObj.notifyAll();
            }
            storehouse.add(new Object());
            System.out.println(Thread.currentThread() + ": Produce item");
            try {
                lockObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}