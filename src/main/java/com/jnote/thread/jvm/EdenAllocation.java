package com.jnote.thread.jvm;

public class EdenAllocation {

    private static  final  int _1MB = 1024*1024;

    public static  void testAllocation(){
        byte [] allocation1 , allocation2, allocation3 , allocation4;

        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];
    }

    /**
     * -verbose:gc -Xms20m -Xmn10M -XX:PrintGCDetails -XX:PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        testAllocation();
    }
}
