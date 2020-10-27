package patterns.vistor;

public interface Element {

    /*
    *  当需要实现新功能时，可以通过实现 Visitor 接口来添加，而不需要改动具体的类
    * */
    void accept(Visitor visitor);

    void someOps();
}
