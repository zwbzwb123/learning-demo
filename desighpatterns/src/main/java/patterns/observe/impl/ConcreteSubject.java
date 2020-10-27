package patterns.observe.impl;

import patterns.observe.Observer;
import patterns.observe.Subject;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {

    private ArrayList<Observer>
                observers = new ArrayList<>(10);

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observers)
            observer.update(this);
    }
}
