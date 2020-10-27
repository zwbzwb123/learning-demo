package patterns.proxy.staticproxy;

import patterns.proxy.Subject;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("do something");
    }
}

