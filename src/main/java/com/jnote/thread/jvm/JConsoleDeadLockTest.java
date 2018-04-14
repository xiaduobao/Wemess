package com.jnote.thread.jvm;

public class JConsoleDeadLockTest {
    static  class  SynAddRunnalbe implements  Runnable{
        int a ,b;

        public  SynAddRunnalbe(int a ,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<1;i++){
            new Thread(new SynAddRunnalbe(1,2),"SynAddRunnalbe"+(2*i)).start();
            new Thread(new SynAddRunnalbe(2,1),"SynAddRunnalbe"+(2*i+1)).start();
        }
    }

}
