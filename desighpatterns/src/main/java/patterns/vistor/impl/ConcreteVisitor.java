package patterns.vistor.impl;

import patterns.vistor.Visitor;

public class ConcreteVisitor implements Visitor {

    @Override
    public void visitElementA(ConcreteElementA element) {
        element.someOps();
    }

    @Override
    public void visitElementB(ConcreteElementB element) {
        element.someOps();
    }
}
