package patterns.factory.abstractfactory.factory.impl;

import patterns.factory.abstractfactory.factory.ProductFactory;
import patterns.factory.abstractfactory.product.ProductA;
import patterns.factory.abstractfactory.product.ProductB;
import patterns.factory.abstractfactory.product.impl.ProductA2Impl;
import patterns.factory.abstractfactory.product.impl.ProductB2Impl;

public class SchemeB implements ProductFactory {
    public ProductA createProductA() {
        return new ProductA2Impl();
    }

    public ProductB createProductB() {
        return new ProductB2Impl();
    }
}
