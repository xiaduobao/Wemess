package com.jnote.pattern;

public class Worker1 implements WorkChain{
    @Override
    public void execute() {
        System.out.println("work1");
    }
}
