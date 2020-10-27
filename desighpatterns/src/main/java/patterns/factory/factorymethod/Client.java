package patterns.factory.factorymethod;

import patterns.factory.factorymethod.factory.ProductFactory;
import patterns.factory.factorymethod.factory.impl.ProductAFactory;
import patterns.factory.factorymethod.product.Product;

public class Client {
    public static void main(String[] args) {

        ProductFactory factoryA = new ProductAFactory();
        Product product = factoryA.getProduct();

    }
}
