package patterns.command;

import patterns.command.impl.AddCommand;
import patterns.command.impl.ConcreteReceiver;
import patterns.command.impl.MultiCommand;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws InterruptedException {
//            Receiver receiver = new ConcreteReceiver();
//            Invoker invoker = new Invoker();
//            invoker.setAddCommand(new AddCommand(receiver));
//            invoker.setMultiCommand(new MultiCommand(receiver));
//            invoker.add();
//            invoker.multi();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
