package patterns.observe.impl;

import patterns.observe.Observer;
import patterns.observe.Subject;

import java.nio.channels.Pipe;

public class ConcreteObserver implements Observer {

    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update(Subject subject) {
        // get some info
    }
}
