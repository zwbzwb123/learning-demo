package patterns.mediator.impl;

import patterns.mediator.Colleague;

/*
*  实际情况下，相互交互的对象大部分本身是没有公共父类的
*  参考一个 CPU对象、主板对象的交互
* */
public abstract class AbstractColleague implements Colleague {

    protected  boolean hasFreeTime = true;

    public void startWork() {
        hasFreeTime = false;
    }

    public abstract void helpWork();

    public boolean hasFreeTime() {
        return hasFreeTime;
    }
}
