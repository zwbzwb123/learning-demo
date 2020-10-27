package patterns.vistor.impl;

import patterns.vistor.Element;
import patterns.vistor.Visitor;

public class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    @Override
    public void someOps() {

    }
}
