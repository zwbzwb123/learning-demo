package patterns.singleton;

/*
*  定义：使得一个类只有一个实例对象，并提供一个全局访问点
* */
public class Singleton {

    // 私有化构造方法
    private Singleton(){}

    private static Singleton staticInstance;

    // 由 JVM 确保只有一个线程执行类加载
    static {
        staticInstance = new Singleton();
    }

    public static Singleton getInstanceByStaticBlock(){
        return staticInstance;
    }

    // volatile 用于防止因指令重排序而导致的内存分配完但是没有完成初始化
    private static volatile Singleton doubleCheckInstance;

    // 双重检查
    public  static Singleton getInstanceByDoubleCheck(){
        if (doubleCheckInstance == null){
            synchronized (doubleCheckInstance) {
                if (doubleCheckInstance == null){
                    doubleCheckInstance = new Singleton();
                }
            }
        }
        return doubleCheckInstance;
    }


    // 通过静态内部类可以做到延迟加载以及线程安全
    private static class InstanceHolder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstanceByInnerClass(){
        return InstanceHolder.instance;
    }

}
