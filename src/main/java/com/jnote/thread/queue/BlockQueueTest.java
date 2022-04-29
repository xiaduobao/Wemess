package com.jnote.thread.queue;

import java.util.AbstractQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BlockQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer(1);
        System.out.println(queue.peek());
        Random random = new Random();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.add(random.nextInt(100));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.poll();
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Producer {

    private AbstractQueue queue;

    //private boolean


}
