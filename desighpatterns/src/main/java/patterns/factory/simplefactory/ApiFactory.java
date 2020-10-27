package patterns.factory.simplefactory;

import patterns.factory.simplefactory.imple.ImplA;
import patterns.factory.simplefactory.imple.ImplB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 *  简单工厂实现了客户端和具体实现类的解耦，使得客户端不需要知道具体的实现类就可以使用
 *  编码简单
 *
 * */
public class ApiFactory {

    private static final int IMPL_A = 1 << 1;
    private static final int IMPL_B = 1 << 2;


    /*
    * 不方便扩展
    * */
    Api createApi() {
        return new ImplA();
    }

    /*
    *  使用参数的方式会使得客户端要理解各个参数的意义，增加难度
    * */
    Api createApi(int condition) {
        Api api = null;
        if (condition == IMPL_A)
            api = new ImplA();
        else if (condition == IMPL_B)
            api = new ImplB();
        return api;
    }


    /*
    * 通过配置文件的方式可以较为方便的进行扩展
    * */
    Api createApiByProperties(){
        Api api = null;
        Properties properties = new Properties();
        InputStream factoryInputStream = null;
        try {
            factoryInputStream = ApiFactory.class.
                    getClassLoader().getResourceAsStream("Factory.properties");
            properties.load(factoryInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                factoryInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String value = properties.getProperty("Api");
        try {
            api = (Api)Class.forName(value).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return api;
    }
}
