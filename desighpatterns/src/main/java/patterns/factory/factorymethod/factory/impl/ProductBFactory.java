package patterns.factory.factorymethod.factory.impl;

import patterns.factory.factorymethod.factory.ProductFactory;
import patterns.factory.factorymethod.product.Product;
import patterns.factory.factorymethod.product.impl.ProductB;

public class ProductBFactory extends ProductFactory {
    protected Product createProduct() {
        return new ProductB();
    }
}
