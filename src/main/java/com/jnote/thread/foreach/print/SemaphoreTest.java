package com.jnote.thread.foreach.print;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        System.out.println("hello");

        semaphore.acquire();
        System.out.println("hello");

        semaphore.acquire();
        System.out.println("hello");

        semaphore.release();
        System.out.println("hell01");

    }


}
