package com.jnote.thread.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args： -Xms20m -Xmx20m -xx:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
static  class  OOMObject{
      byte [] bytes  = new byte[1000];
}

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
            Thread.sleep(1);
        }
    }

}
