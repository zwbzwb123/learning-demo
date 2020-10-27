package patterns.chain.impl;

import patterns.chain.Handler;

public class ConcreteHandlerA implements Handler {

    private Handler successor;

    public ConcreteHandlerA(Handler successor) {
        this.successor = successor;
    }

    @Override
    public Object handlerResult() {
        // do something
        boolean condition = true;
        if (condition){
            return null;
        } else {
            return this.successor.handlerResult();
        }
    }
}
