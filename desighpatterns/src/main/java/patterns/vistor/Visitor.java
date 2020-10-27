package patterns.vistor;

import patterns.vistor.impl.ConcreteElementA;
import patterns.vistor.impl.ConcreteElementB;

/*
*   访问者模式能给一系列对象透明的添加新功能
*   装饰者模式则是在原有的功能上进行增强
* */
public interface Visitor {

    void visitElementA(ConcreteElementA element);

    void visitElementB(ConcreteElementB element);
}
