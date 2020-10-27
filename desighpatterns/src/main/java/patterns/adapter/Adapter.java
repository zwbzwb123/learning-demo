package patterns.adapter;

import patterns.adapter.impl.AbstractTarget;

/*
*  适配器主要功能是属于功能复用,将本来不兼容的类转换匹配
*  转换匹配是手段，功能复用是目的
* */
public class Adapter implements Target{

    Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.anotherRequest();
    }
}

/*
*   也可以做缺省适配,只适配部分功能
* */
class DefaultAdapter extends AbstractTarget {

    Adaptee adaptee;

    public DefaultAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.anotherRequest();
    }
}
