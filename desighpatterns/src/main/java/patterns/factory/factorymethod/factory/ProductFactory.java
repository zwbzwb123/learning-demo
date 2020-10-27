package patterns.factory.factorymethod.factory;

import patterns.factory.factorymethod.product.Product;

public abstract class ProductFactory {

    /*
    * 工厂方法模式的本质：延迟到子类来选择实现
    * 也可以用来将对象及其行为分离
    * */
    public Product getProduct(){
        return createProduct();
    }

    protected abstract Product createProduct();
}
