package com.jnote.thread.jvm;

public class JavaVMStackSOF {
    private int stackLength = 1 ;

    public void stackLeak() throws InterruptedException {
        stackLength++;
        //Thread.sleep(1);
        stackLeak();
    }

    public static void main(String[] args) throws  Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();

        }catch (Throwable e){
            System.out.println("stack length: "+oom.stackLength);
            throw e;
        }

    }
}
