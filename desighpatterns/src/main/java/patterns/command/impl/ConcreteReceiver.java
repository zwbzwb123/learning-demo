package patterns.command.impl;

import patterns.command.Receiver;

public class ConcreteReceiver implements Receiver {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void multi() {
        System.out.println("multi");
    }
}
