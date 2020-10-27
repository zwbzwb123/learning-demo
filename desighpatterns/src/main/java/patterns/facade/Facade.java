package patterns.facade;

import patterns.facade.impl.ModelAImpl;
import patterns.facade.impl.ModelBImpl;

/*
*   外观模式的目的：减少外部与子系统的交互，使得外部更容易使用子系统
*
*   何时可以使用外观模式？
*   1. 为一个复杂的子系统提供一个简单的接口，简化客户端调用
*   2. 使客户端与抽象类的实现部分松散耦合，使用外观对象将客户端与抽象类分离
*   3. 多层结构的系统，可以利用外观对象作为入口
*
* */
public class Facade {

    // 一般不需要实例化外观对象
    private Facade(){}

    // 外观模式仅仅是实现功能的组合，最好不要进行逻辑处理
    public static void test(){
        ModelA a = new ModelAImpl();
        a.doSomething();
        ModelB b = new ModelBImpl();
        b.doSomething();
    }

    public static void main(String[] args) {

        // 客户端需要知道具体的模块
        ModelA a = new ModelAImpl();
        a.doSomething();
        ModelB b = new ModelBImpl();
        b.doSomething();

        // 屏蔽内部细节，简化客户端使用
        Facade.test();
    }
}
