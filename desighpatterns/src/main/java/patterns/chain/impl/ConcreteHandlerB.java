package patterns.chain.impl;

import patterns.chain.Handler;

public class ConcreteHandlerB implements Handler {

    Handler successor;

    public ConcreteHandlerB(Handler successor) {
        this.successor = successor;
    }

    @Override
    public Object handlerResult() {
        return null;
    }
}
