package patterns.builder;

import patterns.builder.impl.ProductBuilder;

public class Client {
    public static void main(String[] args) {
        ProductBuilder builder = new ProductBuilder();
        Director director = new Director(builder);
        director.constructor();
    }
}
