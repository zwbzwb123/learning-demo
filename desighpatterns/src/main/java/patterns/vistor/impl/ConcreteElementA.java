package patterns.vistor.impl;

import patterns.vistor.Element;
import patterns.vistor.Visitor;

public class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    @Override
    public void someOps() {

    }
}
