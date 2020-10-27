package patterns.factory.abstractfactory.factory;

import patterns.factory.abstractfactory.product.ProductA;
import patterns.factory.abstractfactory.product.ProductB;

/*
*  抽象工厂本质：选择产品簇的实现
* */
public interface ProductFactory {

    // 接口的方法之间是存在联系的

    ProductA createProductA();

    ProductB createProductB();
}
