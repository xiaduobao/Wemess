package com.jnote.thread.jvm;

import java.util.ArrayList;
import java.util.List;

public class JConsoleHeapTest {
    static  class  OOMObject{
        public  byte[] placeholder = new byte[64*1024];
    }

    public  static  void fillHeap(int num) throws  InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for(int i =0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        fillHeap(1000);
    }

}
