package com.jnote.thread.jvm;

public class TenuringThreshold {

    private static final  int _1MB  = 1024*1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivoratio=8 -XX:MaxTenuringThreshold=1
     */
    public static  void testTenuringThreshold(){
        byte [] allocation1 , allocation2 , allocation3;
        allocation1 =  new byte[_1MB/4];
        allocation2 = new byte[4*_1MB];
        allocation3 = new byte[4*_1MB];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];
    }

    public static void main(String[] args) throws InterruptedException {
        testTenuringThreshold();
        System.gc();
        Thread.sleep(1000);
        System.gc();

        Thread.sleep(1000*1000);
    }
}


