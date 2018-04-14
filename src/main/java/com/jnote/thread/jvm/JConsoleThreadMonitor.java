package com.jnote.thread.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JConsoleThreadMonitor {

    public static  void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ;
                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static  void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(1000*10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object object = new Object();
        createLockThread(object);

    }

}
