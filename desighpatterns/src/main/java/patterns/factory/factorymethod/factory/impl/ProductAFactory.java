package patterns.factory.factorymethod.factory.impl;

import patterns.factory.factorymethod.factory.ProductFactory;
import patterns.factory.factorymethod.product.Product;
import patterns.factory.factorymethod.product.impl.ProductA;

public class ProductAFactory extends ProductFactory {
    protected Product createProduct() {
        return new ProductA();
    }
}
