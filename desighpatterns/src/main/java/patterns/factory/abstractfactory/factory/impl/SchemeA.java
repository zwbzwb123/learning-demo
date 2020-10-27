package patterns.factory.abstractfactory.factory.impl;

import patterns.factory.abstractfactory.factory.ProductFactory;
import patterns.factory.abstractfactory.product.ProductA;
import patterns.factory.abstractfactory.product.ProductB;
import patterns.factory.abstractfactory.product.impl.ProductAImpl;
import patterns.factory.abstractfactory.product.impl.ProductBImpl;

public class SchemeA implements ProductFactory {

    public ProductA createProductA() {
        return new ProductAImpl();
    }

    public ProductB createProductB() {
        return new ProductBImpl();
    }
}
