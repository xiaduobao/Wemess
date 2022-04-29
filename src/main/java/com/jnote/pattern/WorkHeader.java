package com.jnote.pattern;

import java.util.ArrayList;
import java.util.List;

public class WorkHeader implements WorkChain {

    List<WorkChain> workChains = new ArrayList<>();

    @Override
    public void execute() {
        for (WorkChain work : workChains) {
            work.execute();
        }
    }

    public void addWork(WorkChain workChain) {
        workChains.add(workChain);
    }

    public static void main(String[] args) {

        WorkHeader workHeader = new WorkHeader();
        workHeader.addWork(new Worker1());
        workHeader.addWork(new Worker2());
        workHeader.addWork(new Worker3());
        workHeader.execute();
    }
}
