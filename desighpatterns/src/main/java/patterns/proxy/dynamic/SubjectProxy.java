package patterns.proxy.dynamic;

import java.lang.reflect.Proxy;

public class SubjectProxy {

    public Object createProxy(Object obj) {
        Class clazz = obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
            System.out.println("===");
            return method.invoke(args);
        });
    }
}


