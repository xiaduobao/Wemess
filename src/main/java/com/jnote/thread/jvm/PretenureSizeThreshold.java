package com.jnote.thread.jvm;

public class PretenureSizeThreshold {

    /**
     *  -verbose：gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=9 -XX:PretenureSizeThreshold=3145728
     */
    private static  final  int _1MB =1024*1024;
    public static void  testPretenureSizeThreshold(){
        byte [] allocation ;
        allocation = new byte[3*_1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
